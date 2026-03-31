package com.vianai.greenhouse.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vianai.greenhouse.VghPane
import com.vianai.greenhouse.theme.SpaceBlue
import com.vianai.greenhouse.theme.TextSecondary
import androidx.compose.material3.MaterialTheme

@Composable
fun TopBar(activePane: VghPane, onPaneSelected: (VghPane) -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().height(56.dp).background(SpaceBlack), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        VghPane.values().forEach { pane ->
            val isActive = pane == activePane
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(1f).clickable { onPaneSelected(pane) }.padding(vertical = 8.dp)) {
                Text(text = pane.name, color = if (isActive) SpaceBlue else TextSecondary, style = MaterialTheme.typography.labelLarge)
                if (isActive) Box(modifier = Modifier.size(4.dp).background(SpaceBlue).padding(top = 4.dp))
            }
        }
    }
}
