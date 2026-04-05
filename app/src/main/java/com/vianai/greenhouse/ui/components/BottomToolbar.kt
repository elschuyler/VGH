package com.vianai.greenhouse.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BottomToolbar(
    modifier: Modifier = Modifier,
    items: List<BottomToolbarItem>,
    onItemClick: (BottomToolbarItem) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            IconButton(
                onClick = { onItemClick(item) }
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.label,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

data class BottomToolbarItem(
    val id: String,
    val label: String,
    val icon: ImageVector
)
