package ru.alphaecosystem.alphaecosystem.presentation.screens.models

data class BinInfo(
    val cardNumber: String = "",
    val country: String,
    val coordinates: Coordinates?,
    val cardType: String,
    val bankName: String,
    val bankUrl: String,
    val bankTel: String,
    val bankCity: String,
)
