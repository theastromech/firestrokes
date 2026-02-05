package com.firestrokes.firestrokes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firestrokes.firestrokes.data.local.ThemeManager
import com.firestrokes.firestrokes.domain.model.KeyboardTheme
import com.firestrokes.firestrokes.domain.model.KeyboardThemes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(
    private val themeManager: ThemeManager
) : ViewModel() {
    
    private val _currentTheme = MutableStateFlow(themeManager.currentTheme)
    val currentTheme: StateFlow<KeyboardTheme> = _currentTheme.asStateFlow()
    
    val availableThemes = KeyboardThemes.ALL_THEMES
    
    fun setTheme(theme: KeyboardTheme) {
        viewModelScope.launch {
            themeManager.currentTheme = theme
            _currentTheme.value = theme
        }
    }
    
    fun resetToDefault() {
        viewModelScope.launch {
            themeManager.resetToDefault()
            _currentTheme.value = themeManager.currentTheme
        }
    }
}
