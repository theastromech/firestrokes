package com.firestrokes.firestrokes.presentation.service

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo

class FireStrokesKeyboardService : InputMethodService() {
    
    private var keyboardView: KeyboardView? = null
    private var currentEditorInfo: EditorInfo? = null

    override fun onCreateInputView(): View {
        keyboardView = KeyboardView(this).apply {
            setInputConnection(currentInputConnection)
        }
        return keyboardView!!
    }

    override fun onStartInputView(info: EditorInfo, restarting: Boolean) {
        super.onStartInputView(info, restarting)
        currentEditorInfo = info
        keyboardView?.setInputConnection(currentInputConnection)
    }

    override fun onFinishInput() {
        super.onFinishInput()
        currentEditorInfo = null
    }
    
    override fun onUpdateSelection(
        oldSelStart: Int,
        oldSelEnd: Int,
        newSelStart: Int,
        newSelEnd: Int,
        candidatesStart: Int,
        candidatesEnd: Int
    ) {
        super.onUpdateSelection(
            oldSelStart,
            oldSelEnd,
            newSelStart,
            newSelEnd,
            candidatesStart,
            candidatesEnd
        )
    }
}
