package com.vianai.greenhouse.theme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

val Inter = FontFamily.Default
val JetBrainsMono = FontFamily.Monospace

val VghTypography = Typography(
    bodyLarge = TextStyle(fontFamily = Inter, fontWeight = androidx.compose.ui.text.font.FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp, color = TextPrimary),
    labelLarge = TextStyle(fontFamily = Inter, fontWeight = androidx.compose.ui.text.font.FontWeight.Medium, fontSize = 14.sp, color = TextPrimary),
    bodyMedium = TextStyle(fontFamily = JetBrainsMono, fontWeight = androidx.compose.ui.text.font.FontWeight.Normal, fontSize = 13.sp, lineHeight = 20.sp, color = TextPrimary)
)
