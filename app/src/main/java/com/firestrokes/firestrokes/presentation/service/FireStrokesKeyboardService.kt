package com.firestrokes.firestrokes.presentation.service

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo

class FireStrokesKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        return super.onCreateInputView()
    }

    override fun onStartInputView(info: EditorInfo, restarting: Boolean) {
        super.onStartInputView(info, restarting)
    }

    override fun onFinishInput() {
        super.onFinishInput()
    }
}
