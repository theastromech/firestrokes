package com.firestrokes.firestrokes.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.firestrokes.firestrokes.domain.model.KeyboardTheme
import com.firestrokes.firestrokes.domain.model.KeyboardThemes

@Composable
fun KeyboardMaterialTheme(
    theme: KeyboardTheme,
    content: @Composable () -> Unit
) {
    val colorScheme = if (theme.id == KeyboardThemes.DEFAULT.id) {
        lightColorScheme(
            primary = theme.primary,
            secondary = theme.secondary,
            tertiary = theme.tertiary,
            background = theme.background,
            surface = theme.surface,
            error = theme.error,
            onPrimary = theme.onPrimary,
            onSecondary = theme.onSecondary,
            onTertiary = theme.onTertiary,
            onBackground = theme.onBackground,
            onSurface = theme.onSurface,
            onError = theme.onError
        )
    } else {
        darkColorScheme(
            primary = theme.primary,
            secondary = theme.secondary,
            tertiary = theme.tertiary,
            background = theme.background,
            surface = theme.surface,
            error = theme.error,
            onPrimary = theme.onPrimary,
            onSecondary = theme.onSecondary,
            onTertiary = theme.onTertiary,
            onBackground = theme.onBackground,
            onSurface = theme.onSurface,
            onError = theme.onError
        )
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
