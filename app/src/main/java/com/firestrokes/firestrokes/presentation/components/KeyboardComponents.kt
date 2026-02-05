package com.firestrokes.firestrokes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firestrokes.firestrokes.domain.model.KeyboardKey
import com.firestrokes.firestrokes.domain.model.KeyType

@Composable
fun KeyboardKey(
    key: KeyboardKey,
    onPress: (KeyboardKey) -> Unit
) {
    val backgroundColor = when (key.type) {
        KeyType.SHIFT, KeyType.BACKSPACE, KeyType.ENTER, KeyType.EMOJI -> 
            MaterialTheme.colorScheme.secondaryContainer
        KeyType.SPACE -> MaterialTheme.colorScheme.surface
        else -> MaterialTheme.colorScheme.primary
    }
    
    val contentColor = when (key.type) {
        KeyType.SPACE -> MaterialTheme.colorScheme.onSurface
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
            fontSize = if (key.type == KeyType.SPACE) 14.sp else 18.sp,
            fontWeight = if (key.type == KeyType.SPACE) FontWeight.Normal else FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun KeyboardRow(
    keys: List<KeyboardKey>,
    modifier: Modifier = Modifier,
    onKeyPress: (KeyboardKey) -> Unit
) {
    Row(
        modifier = modifier
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
fun KeyboardPreview(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Keyboard Preview",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
