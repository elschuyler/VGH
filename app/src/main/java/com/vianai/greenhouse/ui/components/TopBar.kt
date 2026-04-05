package com.vianai.greenhouse.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vianai.greenhouse.theme.SpaceBlack
import com.vianai.greenhouse.theme.VghCharcoal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null,
) {
    TopAppBar(
        title = { Text(text = title) },
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions ?: {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = VghCharcoal,
            titleContentColor = SpaceBlack,
            navigationIconContentColor = SpaceBlack,
            actionIconContentColor = SpaceBlack
        )
    )
}
