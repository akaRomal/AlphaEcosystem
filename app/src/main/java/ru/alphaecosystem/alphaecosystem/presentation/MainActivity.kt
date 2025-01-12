package ru.alphaecosystem.alphaecosystem.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alphaecosystem.alphaecosystem.presentation.ui.theme.AlphaEcosystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlphaEcosystemTheme {
            }
        }
    }
}