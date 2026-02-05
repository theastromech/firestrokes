package com.firestrokes.firestrokes.presentation.service

import android.content.Context
import android.view.inputmethod.InputConnection
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class KeyboardView(context: Context) : FrameLayout(context) {
    
    private var inputConnection: InputConnection? = null
    private val hapticFeedback = HapticFeedbackManager(context)
    
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
    
    private fun handleKeyPress(key: KeyData) {
        provideHapticFeedback(key.type)
        val ic = inputConnection ?: return
        
        when (key.type) {
            KeyTypeData.CHAR, KeyTypeData.NUMBER, KeyTypeData.SYMBOL -> {
                ic.commitText(key.display, 1)
            }
            KeyTypeData.SPACE -> {
                ic.commitText(" ", 1)
            }
            KeyTypeData.BACKSPACE -> {
                ic.deleteSurroundingText(1, 0)
            }
            KeyTypeData.ENTER -> {
                ic.sendKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, android.view.KeyEvent.KEYCODE_ENTER))
                ic.sendKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_UP, android.view.KeyEvent.KEYCODE_ENTER))
            }
            KeyTypeData.SHIFT -> {}
            KeyTypeData.EMOJI -> {}
        }
    }
    
    private fun provideHapticFeedback(keyType: KeyTypeData) {
        when (keyType) {
            KeyTypeData.SHIFT,
            KeyTypeData.ENTER,
            KeyTypeData.BACKSPACE,
            KeyTypeData.EMOJI -> hapticFeedback.vibrateSpecialKey()
            KeyTypeData.SPACE -> hapticFeedback.vibrateLongPress()
            else -> hapticFeedback.vibrateKeyPress()
        }
    }
}

data class KeyData(
    val display: String,
    val type: KeyTypeData,
    val width: Float = 1f
)

enum class KeyTypeData {
    CHAR, NUMBER, SYMBOL, SHIFT, BACKSPACE, SPACE, ENTER, EMOJI
}

@Composable
fun FireStrokesKeyboard(
    onKeyPress: (KeyData) -> Unit
) {
    var isShifted by remember { mutableStateOf(false) }
    val isNumeric by remember { mutableStateOf(false) }
    
    val alphaKeys = if (isShifted) {
        listOf(
            "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"
        )
    } else {
        listOf(
            "q", "w", "e", "r", "t", "y", "u", "i", "o", "p"
        )
    }
    
    val homeKeys = if (isShifted) {
        listOf(
            KeyData("A", KeyTypeData.CHAR, 1.2f),
            KeyData("S", KeyTypeData.CHAR),
            KeyData("D", KeyTypeData.CHAR),
            KeyData("F", KeyTypeData.CHAR),
            KeyData("G", KeyTypeData.CHAR),
            KeyData("H", KeyTypeData.CHAR),
            KeyData("J", KeyTypeData.CHAR),
            KeyData("K", KeyTypeData.CHAR),
            KeyData("L", KeyTypeData.CHAR),
            KeyData("⌫", KeyTypeData.BACKSPACE, 1.5f)
        )
    } else {
        listOf(
            KeyData("a", KeyTypeData.CHAR, 1.2f),
            KeyData("s", KeyTypeData.CHAR),
            KeyData("d", KeyTypeData.CHAR),
            KeyData("f", KeyTypeData.CHAR),
            KeyData("g", KeyTypeData.CHAR),
            KeyData("h", KeyTypeData.CHAR),
            KeyData("j", KeyTypeData.CHAR),
            KeyData("k", KeyTypeData.CHAR),
            KeyData("l", KeyTypeData.CHAR),
            KeyData("⌫", KeyTypeData.BACKSPACE, 1.5f)
        )
    }
    
    val bottomKeys = if (isShifted) {
        listOf(
            KeyData("⇧", KeyTypeData.SHIFT, 2f),
            KeyData("Z", KeyTypeData.CHAR),
            KeyData("X", KeyTypeData.CHAR),
            KeyData("C", KeyTypeData.CHAR),
            KeyData("V", KeyTypeData.CHAR),
            KeyData("B", KeyTypeData.CHAR),
            KeyData("N", KeyTypeData.CHAR),
            KeyData("M", KeyTypeData.CHAR),
            KeyData("↵", KeyTypeData.ENTER, 1.5f)
        )
    } else {
        listOf(
            KeyData("⇧", KeyTypeData.SHIFT, 2f),
            KeyData("z", KeyTypeData.CHAR),
            KeyData("x", KeyTypeData.CHAR),
            KeyData("c", KeyTypeData.CHAR),
            KeyData("v", KeyTypeData.CHAR),
            KeyData("b", KeyTypeData.CHAR),
            KeyData("n", KeyTypeData.CHAR),
            KeyData("m", KeyTypeData.CHAR),
            KeyData("↵", KeyTypeData.ENTER, 1.5f)
        )
    }
    
    val spaceRow = listOf(
        KeyData("?123", KeyTypeData.SYMBOL, 1.5f),
        KeyData(", ", KeyTypeData.CHAR, 1.5f),
        KeyData(" ", KeyTypeData.SPACE, 5f),
        KeyData(". ", KeyTypeData.CHAR, 1.5f),
        KeyData("😊", KeyTypeData.EMOJI, 1.5f)
    )
    
    val numericRow = listOf(
        KeyData("1", KeyTypeData.NUMBER),
        KeyData("2", KeyTypeData.NUMBER),
        KeyData("3", KeyTypeData.NUMBER),
        KeyData("4", KeyTypeData.NUMBER),
        KeyData("5", KeyTypeData.NUMBER),
        KeyData("6", KeyTypeData.NUMBER),
        KeyData("7", KeyTypeData.NUMBER),
        KeyData("8", KeyTypeData.NUMBER),
        KeyData("9", KeyTypeData.NUMBER),
        KeyData("0", KeyTypeData.NUMBER)
    )
    
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                if (isNumeric) {
                    KeyboardRow(keys = numericRow, onKeyPress = onKeyPress)
                    KeyboardRow(keys = listOf(
                        KeyData("-", KeyTypeData.SYMBOL),
                        KeyData("/", KeyTypeData.SYMBOL),
                        KeyData(":", KeyTypeData.SYMBOL),
                        KeyData(";", KeyTypeData.SYMBOL),
                        KeyData("(", KeyTypeData.SYMBOL),
                        KeyData(")", KeyTypeData.SYMBOL),
                        KeyData("$", KeyTypeData.SYMBOL),
                        KeyData("&", KeyTypeData.SYMBOL),
                        KeyData("@", KeyTypeData.SYMBOL),
                        KeyData("⌫", KeyTypeData.BACKSPACE)
                    ), onKeyPress = onKeyPress)
                    KeyboardRow(keys = listOf(
                        KeyData("#+=", KeyTypeData.SYMBOL),
                        KeyData(".", KeyTypeData.SYMBOL),
                        KeyData(",", KeyTypeData.SYMBOL),
                        KeyData("?", KeyTypeData.SYMBOL),
                        KeyData("!", KeyTypeData.SYMBOL),
                        KeyData("'", KeyTypeData.SYMBOL),
                        KeyData("\"", KeyTypeData.SYMBOL),
                        KeyData("↵", KeyTypeData.ENTER)
                    ), onKeyPress = onKeyPress)
                    KeyboardRow(keys = listOf(
                        KeyData("ABC", KeyTypeData.SYMBOL),
                        KeyData("_", KeyTypeData.SYMBOL),
                        KeyData(" ", KeyTypeData.SPACE, 3f),
                        KeyData(".", KeyTypeData.SYMBOL),
                        KeyData("😊", KeyTypeData.EMOJI)
                    ), onKeyPress = onKeyPress)
                } else {
                    KeyboardRow(keys = alphaKeys.map { KeyData(it, KeyTypeData.CHAR) }, onKeyPress = onKeyPress)
                    KeyboardRow(keys = homeKeys, onKeyPress = onKeyPress)
                    KeyboardRow(keys = bottomKeys, onKeyPress = onKeyPress)
                    KeyboardRow(keys = spaceRow, onKeyPress = onKeyPress)
                }
            }
        }
    }
}

@Composable
fun KeyboardRow(
    keys: List<KeyData>,
    onKeyPress: (KeyData) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        keys.forEach { key ->
            Box(
                modifier = Modifier.weight(key.width)
            ) {
                KeyboardKey(
                    key = key,
                    onPress = onKeyPress
                )
            }
        }
    }
}

@Composable
fun KeyboardKey(
    key: KeyData,
    onPress: (KeyData) -> Unit
) {
    val backgroundColor = when (key.type) {
        KeyTypeData.SHIFT, KeyTypeData.BACKSPACE, KeyTypeData.ENTER, KeyTypeData.EMOJI -> 
            MaterialTheme.colorScheme.secondaryContainer
        KeyTypeData.SPACE -> MaterialTheme.colorScheme.surface
        else -> MaterialTheme.colorScheme.primary
    }
    
    val contentColor = when (key.type) {
        KeyTypeData.SPACE -> MaterialTheme.colorScheme.onSurface
        else -> MaterialTheme.colorScheme.onPrimary
    }
    
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 2.dp, vertical = 2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable { onPress(key) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = key.display,
            color = contentColor,
            fontSize = if (key.type == KeyTypeData.SPACE) 14.sp else 18.sp,
            fontWeight = if (key.type == KeyTypeData.SPACE) FontWeight.Normal else FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}
