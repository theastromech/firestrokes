package com.firestrokes.firestrokes.domain.model

enum class KeyType {
    CHAR,
    NUMBER,
    SYMBOL,
    SHIFT,
    BACKSPACE,
    SPACE,
    ENTER,
    EMOJI
}

data class KeyboardKey(
    val display: String,
    val code: Int,
    val type: KeyType,
    val width: Float = 1f,
    val isUpperCase: Boolean = false
)

data class KeyboardRow(
    val keys: List<KeyboardKey>
)

data class KeyboardLayout(
    val rows: List<KeyboardRow>
)
