package ru.alphaecosystem.alphaecosystem.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BankInfoEntity.TABLE_NAME)
data class BankInfoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id: Int,
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
    val bankCity: String,
) {
    companion object {
        const val TABLE_NAME = "BankInformation"
        const val ID = "_id"
        const val CARD_NUMBER = "card_number"
        const val COUNTRY = "country"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
        const val CARD_TYPE = "card_type"
        const val BANK_NAME = "bank_name"
        const val BANK_URL = "bank_url"
        const val BANK_TEL = "bank_tel"
        const val BANK_CITY = "bank_city"
    }
}