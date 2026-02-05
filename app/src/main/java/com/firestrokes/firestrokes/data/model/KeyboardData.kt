package com.firestrokes.firestrokes.data.model

import com.firestrokes.firestrokes.domain.model.KeyboardKey
import com.firestrokes.firestrokes.domain.model.KeyboardLayout
import com.firestrokes.firestrokes.domain.model.KeyboardRow
import com.firestrokes.firestrokes.domain.model.KeyType

object KeyboardData {
    
    val qwertyLayout = KeyboardLayout(
        rows = listOf(
            KeyboardRow(
                keys = listOf(
                    KeyboardKey("q", 113, KeyType.CHAR),
                    KeyboardKey("w", 119, KeyType.CHAR),
                    KeyboardKey("e", 101, KeyType.CHAR),
                    KeyboardKey("r", 114, KeyType.CHAR),
                    KeyboardKey("t", 116, KeyType.CHAR),
                    KeyboardKey("y", 121, KeyType.CHAR),
                    KeyboardKey("u", 117, KeyType.CHAR),
                    KeyboardKey("i", 105, KeyType.CHAR),
                    KeyboardKey("o", 111, KeyType.CHAR),
                    KeyboardKey("p", 112, KeyType.CHAR)
                )
            ),
            KeyboardRow(
                keys = listOf(
                    KeyboardKey("a", 97, KeyType.CHAR, width = 1.2f),
                    KeyboardKey("s", 115, KeyType.CHAR),
                    KeyboardKey("d", 100, KeyType.CHAR),
                    KeyboardKey("f", 102, KeyType.CHAR),
                    KeyboardKey("g", 103, KeyType.CHAR),
                    KeyboardKey("h", 104, KeyType.CHAR),
                    KeyboardKey("j", 106, KeyType.CHAR),
                    KeyboardKey("k", 107, KeyType.CHAR),
                    KeyboardKey("l", 108, KeyType.CHAR),
                    KeyboardKey("⌫", 67, KeyType.BACKSPACE, width = 1.5f)
                )
            ),
            KeyboardRow(
                keys = listOf(
                    KeyboardKey("⇧", 59, KeyType.SHIFT, width = 2f),
                    KeyboardKey("z", 122, KeyType.CHAR),
                    KeyboardKey("x", 120, KeyType.CHAR),
                    KeyboardKey("c", 99, KeyType.CHAR),
                    KeyboardKey("v", 118, KeyType.CHAR),
                    KeyboardKey("b", 98, KeyType.CHAR),
                    KeyboardKey("n", 110, KeyType.CHAR),
                    KeyboardKey("m", 109, KeyType.CHAR),
                    KeyboardKey("↵", 66, KeyType.ENTER, width = 1.5f)
                )
            ),
            KeyboardRow(
                keys = listOf(
                    KeyboardKey("?123", 75, KeyType.SYMBOL, width = 1.5f),
                    KeyboardKey(", ", 44, KeyType.CHAR, width = 1.5f),
                    KeyboardKey(" ", 32, KeyType.SPACE, width = 5f),
                    KeyboardKey(". ", 46, KeyType.CHAR, width = 1.5f),
                    KeyboardKey("😊", 69, KeyType.EMOJI, width = 1.5f)
                )
            )
        )
    )
    
    fun getShiftedLayout(layout: KeyboardLayout): KeyboardLayout {
        val shiftedRows = layout.rows.map { row ->
            val shiftedKeys = row.keys.map { key ->
                when (key.type) {
                    KeyType.CHAR -> key.copy(
                        display = key.display.uppercase(),
                        isUpperCase = true
                    )
                    else -> key
                }
            }
            row.copy(keys = shiftedKeys)
        }
        return layout.copy(rows = shiftedRows)
    }
    
    fun getNumericLayout(): KeyboardLayout {
        return KeyboardLayout(
            rows = listOf(
                KeyboardRow(
                    keys = listOf(
                        KeyboardKey("1", 8, KeyType.NUMBER),
                        KeyboardKey("2", 9, KeyType.NUMBER),
                        KeyboardKey("3", 10, KeyType.NUMBER),
                        KeyboardKey("4", 11, KeyType.NUMBER),
                        KeyboardKey("5", 12, KeyType.NUMBER),
                        KeyboardKey("6", 13, KeyType.NUMBER),
                        KeyboardKey("7", 14, KeyType.NUMBER),
                        KeyboardKey("8", 15, KeyType.NUMBER),
                        KeyboardKey("9", 16, KeyType.NUMBER),
                        KeyboardKey("0", 7, KeyType.NUMBER)
                    )
                ),
                KeyboardRow(
                    keys = listOf(
                        KeyboardKey("-", 69, KeyType.SYMBOL),
                        KeyboardKey("/", 76, KeyType.SYMBOL),
                        KeyboardKey(":", 75, KeyType.SYMBOL),
                        KeyboardKey(";", 74, KeyType.SYMBOL),
                        KeyboardKey("(", 40, KeyType.SYMBOL),
                        KeyboardKey(")", 41, KeyType.SYMBOL),
                        KeyboardKey("$", 68, KeyType.SYMBOL),
                        KeyboardKey("&", 38, KeyType.SYMBOL),
                        KeyboardKey("@", 77, KeyType.SYMBOL),
                        KeyboardKey("⌫", 67, KeyType.BACKSPACE)
                    )
                ),
                KeyboardRow(
                    keys = listOf(
                        KeyboardKey("#+=", 61, KeyType.SYMBOL),
                        KeyboardKey(".", 46, KeyType.SYMBOL),
                        KeyboardKey(",", 44, KeyType.SYMBOL),
                        KeyboardKey("?", 16, KeyType.SYMBOL),
                        KeyboardKey("!", 17, KeyType.SYMBOL),
                        KeyboardKey("'", 75, KeyType.SYMBOL),
                        KeyboardKey("\"", 34, KeyType.SYMBOL),
                        KeyboardKey("↵", 66, KeyType.ENTER)
                    )
                ),
                KeyboardRow(
                    keys = listOf(
                        KeyboardKey("ABC", 29, KeyType.SYMBOL),
                        KeyboardKey("_", 95, KeyType.SYMBOL),
                        KeyboardKey(" ", 32, KeyType.SPACE, width = 3f),
                        KeyboardKey(".", 46, KeyType.SYMBOL),
                        KeyboardKey("😊", 69, KeyType.EMOJI)
                    )
                )
            )
        )
    }
}
