package com.firestrokes.firestrokes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firestrokes.firestrokes.data.model.KeyboardData
import com.firestrokes.firestrokes.domain.model.KeyboardLayout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class KeyboardMode {
    QWERTY,
    NUMERIC,
    SYMBOLS
}

class KeyboardViewModel : ViewModel() {
    
    private val _currentLayout = MutableStateFlow(KeyboardData.qwertyLayout)
    val currentLayout: StateFlow<KeyboardLayout> = _currentLayout.asStateFlow()
    
    private val _isShifted = MutableStateFlow(false)
    val isShifted: StateFlow<Boolean> = _isShifted.asStateFlow()
    
    private val _mode = MutableStateFlow(KeyboardMode.QWERTY)
    val mode: StateFlow<KeyboardMode> = _mode.asStateFlow()
    
    fun toggleShift() {
        viewModelScope.launch {
            _isShifted.value = !_isShifted.value
            if (_mode.value == KeyboardMode.QWERTY) {
                _currentLayout.value = if (_isShifted.value) {
                    KeyboardData.getShiftedLayout(KeyboardData.qwertyLayout)
                } else {
                    KeyboardData.qwertyLayout
                }
            }
        }
    }
    
    fun switchToNumeric() {
        viewModelScope.launch {
            _mode.value = KeyboardMode.NUMERIC
            _currentLayout.value = KeyboardData.getNumericLayout()
        }
    }
    
    fun switchToAlpha() {
        viewModelScope.launch {
            _mode.value = KeyboardMode.QWERTY
            _currentLayout.value = if (_isShifted.value) {
                KeyboardData.getShiftedLayout(KeyboardData.qwertyLayout)
            } else {
                KeyboardData.qwertyLayout
            }
        }
    }
    
    fun resetShift() {
        viewModelScope.launch {
            _isShifted.value = false
            if (_mode.value == KeyboardMode.QWERTY) {
                _currentLayout.value = KeyboardData.qwertyLayout
            }
        }
    }
}
