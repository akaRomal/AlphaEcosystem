package ru.alphaecosystem.alphaecosystem.domain.models

data class BinInfoDomain(
    val cardNumber: String = "",
    val country: String,
    val coordinates: CoordinatesDomain?,
    val cardType: String,
    val bankName: String,
    val bankUrl: String,
    val bankTel: String,
    val bankCity: String,
)
