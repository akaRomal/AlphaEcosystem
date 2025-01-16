package ru.alphaecosystem.alphaecosystem.data.remote.models

data class BankInfoApi(
    val scheme: String?=null,
    val country: CountryApi?=null,
    val bank: BankApi?=null,
)
