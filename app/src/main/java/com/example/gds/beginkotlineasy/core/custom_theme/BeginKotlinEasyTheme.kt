package com.example.gds.beginkotlineasy.core.custom_theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.gds.beginkotlineasy.R

// Note to import correct import as I get initially error here
@Composable
fun BeginKotlinEasyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val lightColorScheme = lightColorScheme(
        primary = colorResource(R.color.primary_color),         // Main theme color (e.g., purple)
        onPrimary = colorResource(R.color.white).copy(0.8f),    // Text/icon on primary (slightly transparent white)
        secondary = colorResource(R.color.secondary_color),     // Accent color (e.g., teal)
        onSecondary = colorResource(R.color.white),             // Text/icon on secondary
        primaryContainer = colorResource(R.color.primary_variant_light), // Variant for primary containers
        onPrimaryContainer = colorResource(R.color.white),      // Text/icon on primary container
        secondaryContainer = colorResource(R.color.secondary_variant_light), // Variant for secondary containers
        onSecondaryContainer = colorResource(R.color.white),    // Text/icon on secondary container
        background = colorResource(R.color.background_light),   // App background
        onBackground = colorResource(R.color.on_background_light), // Text/icon on background
        surface = colorResource(R.color.surface_light),         // Cards, sheets, etc.
        onSurface = colorResource(R.color.on_surface_light)     // Text/icon on surface
    )

    val darkColorScheme = darkColorScheme(  // Changed to darkColorScheme for proper dark theme support
        primary = colorResource(R.color.primary_dark),          // Adjusted primary for dark (lighter purple)
        onPrimary = colorResource(R.color.white).copy(0.8f),    // Text/icon on primary
        secondary = colorResource(R.color.secondary_dark),      // Accent color (consistent teal)
        onSecondary = colorResource(R.color.white),             // Text/icon on secondary
        primaryContainer = colorResource(R.color.primary_variant_dark), // Variant for primary containers
        onPrimaryContainer = colorResource(R.color.white),      // Text/icon on primary container
        secondaryContainer = colorResource(R.color.secondary_variant_dark), // Variant for secondary containers
        onSecondaryContainer = colorResource(R.color.white),    // Text/icon on secondary container
        background = colorResource(R.color.background_dark),    // Dark app background
        onBackground = colorResource(R.color.on_background_dark), // Text/icon on background
        surface = colorResource(R.color.surface_dark),          // Cards, sheets in dark mode
        onSurface = colorResource(R.color.on_surface_dark)      // Text/icon on surface
    )

    // Define typography styles
    val typography = Typography(
        // 1. Headline Large - App title in TopAppBar, header in Column
        headlineLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            letterSpacing = 0.sp
        ),
        // 2. Headline Medium - Chapter title in LazyColumn, section in Box
        headlineMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp
        ),
        // 3. Title Large - Lesson title in Card, header in Column
        titleLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        // 4. Title Medium - Card title in ElevatedCard, subsection in LazyRow
        titleMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
        // 5. Body Large - Paragraph in Column, content in Card
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        ),
        // 6. Body Medium - Summary in Card, description in Row
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        ),
        // 7. Label Large - Button text in Button, label in Surface
        labelLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp
        ),
        // 8. Label Medium - Caption below Image, helper in TextField
        labelMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    )

    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme else lightColorScheme,
        typography = typography
    ) {
        content()
    }
}