package com.firestrokes.firestrokes.domain.usecase

import android.view.KeyEvent
import android.view.inputmethod.InputConnection

class HandleKeyPressUseCase {
    
    operator fun invoke(
        inputConnection: InputConnection?,
        key: com.firestrokes.firestrokes.domain.model.KeyboardKey
    ): Boolean {
        val ic = inputConnection ?: return false
        
        return when (key.type) {
            com.firestrokes.firestrokes.domain.model.KeyType.CHAR,
            com.firestrokes.firestrokes.domain.model.KeyType.NUMBER,
            com.firestrokes.firestrokes.domain.model.KeyType.SYMBOL -> {
                ic.commitText(key.display, 1)
                true
            }
            com.firestrokes.firestrokes.domain.model.KeyType.SPACE -> {
                ic.commitText(" ", 1)
                true
            }
            com.firestrokes.firestrokes.domain.model.KeyType.BACKSPACE -> {
                ic.deleteSurroundingText(1, 0)
                true
            }
            com.firestrokes.firestrokes.domain.model.KeyType.ENTER -> {
                ic.sendKeyEvent(
                    KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER)
                )
                ic.sendKeyEvent(
                    KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER)
                )
                true
            }
            com.firestrokes.firestrokes.domain.model.KeyType.SHIFT,
            com.firestrokes.firestrokes.domain.model.KeyType.EMOJI -> {
                false
            }
        }
    }
    
    fun handleDeleteAll(inputConnection: InputConnection?): Boolean {
        val ic = inputConnection ?: return false
        ic.deleteSurroundingText(100, 0)
        return true
    }
    
    fun handleMoveCursor(inputConnection: InputConnection?, direction: Int, amount: Int): Boolean {
        val ic = inputConnection ?: return false
        
        val extractedText = ic.getExtractedText(android.view.inputmethod.ExtractedTextRequest(), 0)
        extractedText?.let { text ->
            val cursorPosition = text.selectionStart
            val newPosition = (cursorPosition + (direction * amount)).coerceIn(0, text.text.length)
            ic.setSelection(newPosition, newPosition)
            return true
        }
        
        return false
    }
}
