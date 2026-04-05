package com.vianai.greenhouse.ui.panes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PaneContainer(
    activePane: Int,
    modifier: Modifier = Modifier
) {
    // Placeholder – will be replaced with actual WebView logic later
    when (activePane) {
        0 -> VghWebView(url = "https://chat.openai.com") // Brain
        1 -> VghWebView(url = "https://github.com")      // Source
        else -> VghWebView(url = "https://duckduckgo.com") // Research
    }
}
