package ru.alphaecosystem.alphaecosystem.data.local.entities

import androidx.room.ColumnInfo
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.BANK_CITY
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.BANK_NAME
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.BANK_TEL
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.BANK_URL
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.CARD_NUMBER
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.CARD_TYPE
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.COUNTRY
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.LATITUDE
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity.Companion.LONGITUDE

data class NewBankInfo(
    @ColumnInfo(name = CARD_NUMBER)
    val cardNumber: String,
    @ColumnInfo(name = COUNTRY)
    val country: String,
    @ColumnInfo(name = LATITUDE)
    val latitude: String,
    @ColumnInfo(name = LONGITUDE)
    val longitude: String,
    @ColumnInfo(name = CARD_TYPE)
    val cardType: String,
    @ColumnInfo(name = BANK_NAME)
    val bankName: String,
    @ColumnInfo(name = BANK_URL)
    val bankUrl: String,
    @ColumnInfo(name = BANK_TEL)
    val bankTel: String,
    @ColumnInfo(name = BANK_CITY)
    val bankCity: String,)
