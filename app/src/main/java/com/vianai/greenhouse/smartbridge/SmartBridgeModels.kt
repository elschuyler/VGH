package com.vianai.greenhouse.smartbridge

data class StagedFile(val path: String, val content: String, val reason: String, val timestamp: Long, val tier: Int, val blockId: String)
data class CaptureState(var isTracking: Boolean = false, var filePath: String? = null, var reason: String? = null, val buffer: MutableList<String> = mutableListOf(), var blockId: String? = null, var detectedTier: Int = 1)

sealed class ParseResult {
    object Idle : ParseResult()
    object TrackingStarted : ParseResult()
    object TrackingUpdated : ParseResult()
    data class CaptureComplete(val file: StagedFile) : ParseResult()
    data class Error(val message: String) : ParseResult()
}

class ProcessedBlockRegistry {
    private val processed = mutableSetOf<String>()
    fun add(blockId: String) = processed.add(blockId)
    fun contains(blockId: String) = blockId in processed
    fun remove(blockId: String) = processed.remove(blockId)
    fun clear() = processed.clear()
}
