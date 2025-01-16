package ru.alphaecosystem.alphaecosystem.presentation.screens.home

import ru.alphaecosystem.alphaecosystem.presentation.screens.models.BinInfo

data class HomeScreenState(
    val cardNumber: String = "",
    val binInfo: BinInfo? = null,
)
