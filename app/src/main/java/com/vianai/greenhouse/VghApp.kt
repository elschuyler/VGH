package com.vianai.greenhouse

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vianai.greenhouse.ui.components.BottomToolbar
import com.vianai.greenhouse.ui.components.BottomToolbarItem
import com.vianai.greenhouse.ui.components.TopBar
import com.vianai.greenhouse.ui.panes.PaneContainer

@Composable
fun VghApp() {
    var activePane by remember { mutableStateOf(0) } // 0=Brain, 1=Source, 2=Research

    Scaffold(
        topBar = {
            TopBar(
                title = when (activePane) {
                    0 -> "Brain"
                    1 -> "Source"
                    else -> "Research"
                }
            )
        },
        bottomBar = {
            BottomToolbar(
                items = listOf(
                    BottomToolbarItem("brain", "Brain", Icons.Default.Android),
                    BottomToolbarItem("source", "Source", Icons.Default.Android),
                    BottomToolbarItem("research", "Research", Icons.Default.Android)
                ),
                onItemClick = { item ->
                    activePane = when (item.id) {
                        "brain" -> 0
                        "source" -> 1
                        else -> 2
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PaneContainer(activePane = activePane)
        }
    }
}
