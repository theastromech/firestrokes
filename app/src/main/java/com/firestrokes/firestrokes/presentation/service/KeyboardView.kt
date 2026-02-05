package com.firestrokes.firestrokes.presentation.service

import android.content.Context
import android.view.inputmethod.InputConnection
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.viewmodel.compose.viewModel
import com.firestrokes.firestrokes.domain.model.KeyType
import com.firestrokes.firestrokes.domain.usecase.HandleKeyPressUseCase
import com.firestrokes.firestrokes.presentation.components.KeyboardRow
import com.firestrokes.firestrokes.presentation.viewmodel.KeyboardViewModel
import com.firestrokes.firestrokes.presentation.viewmodel.SuggestionViewModel
import com.firestrokes.firestrokes.presentation.viewmodel.ThemeViewModel

class KeyboardView(context: Context) : FrameLayout(context) {
    
    private var inputConnection: InputConnection? = null
    private val hapticFeedback = HapticFeedbackManager(context)
    private val handleKeyPressUseCase = HandleKeyPressUseCase()
    
    fun setInputConnection(ic: InputConnection?) {
        inputConnection = ic
    }
    
    init {
        addComposeView()
    }
    
    private fun addComposeView() {
        val composeView = ComposeView(context).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FireStrokesKeyboard { key ->
                    handleKeyPress(key)
                }
            }
        }
        addView(composeView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }
    
    private fun handleKeyPress(key: com.firestrokes.firestrokes.domain.model.KeyboardKey) {
        provideHapticFeedback(key.type)
        handleKeyPressUseCase(inputConnection, key)
    }
    
    private fun provideHapticFeedback(keyType: KeyType) {
        when (keyType) {
            KeyType.SHIFT,
            KeyType.ENTER,
            KeyType.BACKSPACE,
            KeyType.EMOJI -> hapticFeedback.vibrateSpecialKey()
            KeyType.SPACE -> hapticFeedback.vibrateLongPress()
            else -> hapticFeedback.vibrateKeyPress()
        }
    }
}

@Composable
fun FireStrokesKeyboard(
    onKeyPress: (com.firestrokes.firestrokes.domain.model.KeyboardKey) -> Unit
) {
    val viewModel: KeyboardViewModel = viewModel()
    val suggestionViewModel: SuggestionViewModel = viewModel()
    val themeViewModel: ThemeViewModel = viewModel()
    val currentLayout by viewModel.currentLayout.collectAsState()
    val suggestions by suggestionViewModel.currentSuggestions.collectAsState()
    val theme by themeViewModel.currentTheme.collectAsState()
    
    com.firestrokes.firestrokes.presentation.theme.KeyboardMaterialTheme(theme = theme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                if (suggestions.isNotEmpty()) {
                    com.firestrokes.firestrokes.presentation.components.SuggestionBar(
                        suggestions = suggestions,
                        onSuggestionClick = { suggestion ->
                            onKeyPress(
                                com.firestrokes.firestrokes.domain.model.KeyboardKey(
                                    display = suggestion.word,
                                    code = 0,
                                    type = com.firestrokes.firestrokes.domain.model.KeyType.CHAR
                                )
                            )
                        }
                    )
                }
                
                currentLayout.rows.forEach { row ->
                    KeyboardRow(
                        keys = row.keys,
                        onKeyPress = { key ->
                            when (key.type) {
                                com.firestrokes.firestrokes.domain.model.KeyType.SHIFT -> {
                                    viewModel.toggleShift()
                                }
                                com.firestrokes.firestrokes.domain.model.KeyType.SYMBOL -> {
                                    when (key.display) {
                                        "?123" -> viewModel.switchToNumeric()
                                        "#+=" -> {}
                                        "ABC" -> viewModel.switchToAlpha()
                                        else -> onKeyPress(key)
                                    }
                                }
                                else -> {
                                    if (key.type == com.firestrokes.firestrokes.domain.model.KeyType.CHAR ||
                                        key.type == com.firestrokes.firestrokes.domain.model.KeyType.NUMBER ||
                                        key.type == com.firestrokes.firestrokes.domain.model.KeyType.SPACE) {
                                        viewModel.resetShift()
                                    }
                                    onKeyPress(key)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
