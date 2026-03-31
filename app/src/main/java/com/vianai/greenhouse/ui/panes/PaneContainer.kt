package com.vianai.greenhouse.ui.panes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import com.vianai.greenhouse.PaneManager
import com.vianai.greenhouse.VghPane

@Composable
fun PaneContainer(activePane: VghPane, paneManager: PaneManager, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        when (activePane) {
            VghPane.BRAIN -> BrainPane(paneManager)
            VghPane.SOURCE -> SourcePane(paneManager)
            VghPane.RESEARCH -> ResearchPane(paneManager)
        }
    }
    DisposableEffect(activePane) {
        onDispose { paneManager.onPauseInactive(activePane) }
    }
}

@Composable
fun BrainPane(paneManager: PaneManager) {
    VghWebView(url = "https://claude.ai", paneId = "brain", paneManager = paneManager)
}
@Composable
fun SourcePane(paneManager: PaneManager) {
    VghWebView(url = "https://github.com", paneId = "source", paneManager = paneManager)
}
@Composable
fun ResearchPane(paneManager: PaneManager) {
    VghWebView(url = "file:///android_asset/research_start.html", paneId = "research", paneManager = paneManager)
}
