package com.vianai.greenhouse.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Design tokens from handoff
val VghCharcoal = Color(0xFF151619)   // Primary background
val SpaceBlack = Color(0xFF050505)    // Secondary background
val SpaceBlue = Color(0xFF1E90FF)     // Accent
val DarkRed = Color(0xFF8B0000)       // Destructive

// Surface and text aliases for compatibility
val SurfaceDark = VghCharcoal
val TextPrimary = SpaceBlack

@Composable
fun VghTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = SpaceBlue,
            secondary = SpaceBlue,
            tertiary = SpaceBlue,
            background = VghCharcoal,
            surface = VghCharcoal,
            onPrimary = SpaceBlack,
            onSecondary = SpaceBlack,
            onBackground = SpaceBlack,
            onSurface = SpaceBlack
        )
    } else {
        lightColorScheme(
            primary = SpaceBlue,
            secondary = SpaceBlue,
            tertiary = SpaceBlue,
            background = VghCharcoal,
            surface = VghCharcoal,
            onPrimary = SpaceBlack,
            onSecondary = SpaceBlack,
            onBackground = SpaceBlack,
            onSurface = SpaceBlack
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
