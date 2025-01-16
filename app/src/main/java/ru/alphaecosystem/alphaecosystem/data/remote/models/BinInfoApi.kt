package ru.alphaecosystem.alphaecosystem.data.remote.models

data class BinInfoApi(
    val scheme: String?=null,
    val country: CountryApi?=null,
    val bank: BankApi?=null,
)
