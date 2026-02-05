package com.firestrokes.firestrokes.data.local

import android.content.Context
import android.content.SharedPreferences
import com.firestrokes.firestrokes.domain.model.KeyboardTheme
import com.firestrokes.firestrokes.domain.model.KeyboardThemes

class ThemeManager(context: Context) {
    
    private val prefs: SharedPreferences = context.getSharedPreferences(
        PREFS_NAME,
        Context.MODE_PRIVATE
    )
    
    var currentTheme: KeyboardTheme
        get() {
            val themeId = prefs.getString(KEY_THEME_ID, KeyboardThemes.DEFAULT.id) ?: KeyboardThemes.DEFAULT.id
            return KeyboardThemes.getThemeById(themeId)
        }
        set(value) {
            prefs.edit().putString(KEY_THEME_ID, value.id).apply()
        }
    
    fun resetToDefault() {
        prefs.edit().remove(KEY_THEME_ID).apply()
    }
    
    companion object {
        private const val PREFS_NAME = "keyboard_preferences"
        private const val KEY_THEME_ID = "selected_theme_id"
    }
}
