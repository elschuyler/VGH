package com.vianai.greenhouse.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.vianai.greenhouse.theme.VghCharcoal
import com.vianai.greenhouse.theme.SpaceBlue

@Composable
fun BottomToolbar(activePane: com.vianai.greenhouse.VghPane, onPaneCycle: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth().height(64.dp).background(VghCharcoal).pointerInput(Unit) { detectHorizontalDragGestures(onDragEnd = { onPaneCycle() }) }) {
        Row(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            ToolbarSlot()
            ToolbarSlot()
            ToolbarSlot()
        }
    }
}

@Composable
private fun ToolbarSlot() {
    Box(modifier = Modifier.size(48.dp).padding(4.dp).background(SpaceBlue, shape = androidx.compose.foundation.shape.CircleShape))
}
