package com.vianai.greenhouse.smartbridge

class SmartBridgeParser(private val registry: ProcessedBlockRegistry = ProcessedBlockRegistry()) {
    private val capture = CaptureState()
    private val startTagRegex = Regex("""@@\s*VGH-PUSH-START\s*\[\s*file:\s*([^\]]+)\s*\](?:\[\s*reason:\s*([^\]]*)\s*\])?@@?""", setOf(RegexOption.IGNORE_CASE))
    private val endTagRegex = Regex("""@@\s*VGH-PUSH-END\s*\[\s*file:\s*([^\]]+)\s*\]@@?""", setOf(RegexOption.IGNORE_CASE))

    fun processChunk(text: String): ParseResult {
        return if (!capture.isTracking) detectStartTag(text) else bufferOrComplete(text)
    }

    private fun detectStartTag(text: String): ParseResult {
        val match = startTagRegex.find(text) ?: return ParseResult.Idle
        val filePath = match.groupValues[1].trim()
        val reason = match.groupValues[2].takeIf { it.isNotBlank() }?.trim() ?: "No reason provided"
        val blockId = "${filePath}_${reason}"
        if (registry.contains(blockId)) return ParseResult.Idle
        capture.isTracking = true; capture.filePath = filePath; capture.reason = reason; capture.blockId = blockId; capture.buffer.clear()
        return ParseResult.TrackingStarted
    }

    private fun bufferOrComplete(text: String): ParseResult {
        val endMatch = endTagRegex.find(text)
        if (endMatch != null) return completeCapture(endMatch.groupValues[1].trim())
        text.lines().forEach { line -> if (!startTagRegex.matches(line.trim()) && !endTagRegex.matches(line.trim())) capture.buffer.add(line) }
        return ParseResult.TrackingUpdated
    }

    private fun completeCapture(endTagPath: String): ParseResult {
        val startPath = capture.filePath ?: return ParseResult.Error("No start path")
        val blockId = capture.blockId ?: return ParseResult.Error("No blockId")
        val finalPath = if (endTagPath != startPath && startPath.substringAfterLast('/') == endTagPath.substringAfterLast('/')) startPath else endTagPath
        val content = capture.buffer.joinToString("\n").trim()
        if (content.isEmpty()) return ParseResult.Error("Empty")
        val file = StagedFile(finalPath, content, capture.reason ?: "", System.currentTimeMillis(), capture.detectedTier, blockId)
        registry.add(blockId); resetCapture()
        return ParseResult.CaptureComplete(file)
    }

    fun resetCapture() { capture.isTracking = false; capture.filePath = null; capture.reason = null; capture.buffer.clear(); capture.blockId = null }
    fun isTracking(): Boolean = capture.isTracking
    fun clearRegistry() = registry.clear()
}
