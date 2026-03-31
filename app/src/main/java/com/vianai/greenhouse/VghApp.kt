package com.vianai.greenhouse
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.vianai.greenhouse.ui.components.BottomToolbar
import com.vianai.greenhouse.ui.components.TopBar
import com.vianai.greenhouse.ui.panes.PaneContainer

enum class VghPane { BRAIN, SOURCE, RESEARCH }

@Composable
fun VghApp() {
    var activePane by remember { mutableStateOf(VghPane.BRAIN) }
    val paneManager = remember { PaneManager() }
    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        TopBar(activePane = activePane, onPaneSelected = { activePane = it })
        PaneContainer(activePane = activePane, paneManager = paneManager, modifier = Modifier.weight(1f))
        BottomToolbar(activePane = activePane, onPaneCycle = {
            activePane = when (activePane) {
                VghPane.BRAIN -> VghPane.SOURCE
                VghPane.SOURCE -> VghPane.BRAIN
                VghPane.RESEARCH -> VghPane.BRAIN
            }
        })
    }
}
