package ru.alphaecosystem.alphaecosystem.presentation.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun CustomText(title: Int, text: String?) {
    val field = text ?: ""
    Text(text = stringResource(id = title) + field, modifier = Modifier.fillMaxWidth())
}

@Composable
fun CustomText(title: Int, text: String, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = title))
        if (text.isNotEmpty()) {
            Text(text = text, modifier = Modifier.clickable(onClick = onClick), color = Color.Blue)
        }
    }
}