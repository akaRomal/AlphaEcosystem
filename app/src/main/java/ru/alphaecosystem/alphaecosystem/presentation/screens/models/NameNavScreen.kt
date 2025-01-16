package ru.alphaecosystem.alphaecosystem.presentation.screens.models

sealed class NameNavScreen(val route: String) {
    data object Home : NameNavScreen(
        route = "home",
    )

    data object History : NameNavScreen(
        route = "history",
    )
}