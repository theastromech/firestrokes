package com.firestrokes.firestrokes.domain.model

import androidx.compose.ui.graphics.Color

data class KeyboardTheme(
    val name: String,
    val id: String,
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val background: Color,
    val surface: Color,
    val error: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onTertiary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onError: Color
)

object KeyboardThemes {
    
    val DEFAULT = KeyboardTheme(
        name = "Default",
        id = "default",
        primary = Color(0xFF6200EE),
        secondary = Color(0xFF03DAC6),
        tertiary = Color(0xFF018786),
        background = Color(0xFFFFFBFE),
        surface = Color(0xFFFFFBFE),
        error = Color(0xFFB00020),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFF000000),
        onTertiary = Color(0xFFFFFFFF),
        onBackground = Color(0xFF1C1B1F),
        onSurface = Color(0xFF1C1B1F),
        onError = Color(0xFFFFFFFF)
    )
    
    val DARK = KeyboardTheme(
        name = "Dark",
        id = "dark",
        primary = Color(0xFFBB86FC),
        secondary = Color(0xFF03DAC6),
        tertiary = Color(0xFF03DAC6),
        background = Color(0xFF121212),
        surface = Color(0xFF1E1E1E),
        error = Color(0xFFCF6679),
        onPrimary = Color(0xFF000000),
        onSecondary = Color(0xFF000000),
        onTertiary = Color(0xFF000000),
        onBackground = Color(0xFFE1E1E1),
        onSurface = Color(0xFFE1E1E1),
        onError = Color(0xFF000000)
    )
    
    val MIDNIGHT = KeyboardTheme(
        name = "Midnight",
        id = "midnight",
        primary = Color(0xFF2C3E50),
        secondary = Color(0xFF34495E),
        tertiary = Color(0xFF95A5A6),
        background = Color(0xFF1A252F),
        surface = Color(0xFF2C3E50),
        error = Color(0xFFE74C3C),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFFFFFFFF),
        onTertiary = Color(0xFF000000),
        onBackground = Color(0xFFECF0F1),
        onSurface = Color(0xFFFFFFFF),
        onError = Color(0xFFFFFFFF)
    )
    
    val OCEAN = KeyboardTheme(
        name = "Ocean",
        id = "ocean",
        primary = Color(0xFF0077B6),
        secondary = Color(0xFF00B4D8),
        tertiary = Color(0xFF90E0EF),
        background = Color(0xFFCAF0F8),
        surface = Color(0xFF90E0EF),
        error = Color(0xFFD00000),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFFFFFFFF),
        onTertiary = Color(0xFF000000),
        onBackground = Color(0xFF03045E),
        onSurface = Color(0xFF03045E),
        onError = Color(0xFFFFFFFF)
    )
    
    val FOREST = KeyboardTheme(
        name = "Forest",
        id = "forest",
        primary = Color(0xFF2D6A4F),
        secondary = Color(0xFF40916C),
        tertiary = Color(0xFF52B788),
        background = Color(0xFFD8F3DC),
        surface = Color(0xFFB7E4C7),
        error = Color(0xFFD00000),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFFFFFFFF),
        onTertiary = Color(0xFF000000),
        onBackground = Color(0xFF1B4332),
        onSurface = Color(0xFF1B4332),
        onError = Color(0xFFFFFFFF)
    )
    
    val SUNSET = KeyboardTheme(
        name = "Sunset",
        id = "sunset",
        primary = Color(0xFFFF7043),
        secondary = Color(0xFFFFAB91),
        tertiary = Color(0xFFFF8A65),
        background = Color(0xFFFFF3E0),
        surface = Color(0xFFFFCCBC),
        error = Color(0xFFD00000),
        onPrimary = Color(0xFFFFFFFF),
        onSecondary = Color(0xFF000000),
        onTertiary = Color(0xFF000000),
        onBackground = Color(0xFF3E2723),
        onSurface = Color(0xFF3E2723),
        onError = Color(0xFFFFFFFF)
    )
    
    val ALL_THEMES = listOf(
        DEFAULT,
        DARK,
        MIDNIGHT,
        OCEAN,
        FOREST,
        SUNSET
    )
    
    fun getThemeById(id: String): KeyboardTheme {
        return ALL_THEMES.find { it.id == id } ?: DEFAULT
    }
}
