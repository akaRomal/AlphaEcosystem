package ru.alphaecosystem.alphaecosystem.data.repository

import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity
import ru.alphaecosystem.alphaecosystem.data.local.entities.NewBankInfo
import ru.alphaecosystem.alphaecosystem.data.remote.models.BankInfoApi
import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain
import ru.alphaecosystem.alphaecosystem.domain.models.CoordinatesDomain

class Mapper {

    fun fromBinInfoDomainToNewBankInfo(binInfo: BinInfoDomain): NewBankInfo {
        return NewBankInfo(
            cardNumber = binInfo.cardNumber,
            country = binInfo.country,
            latitude = binInfo.coordinates?.latitude ?: "",
            longitude = binInfo.coordinates?.longitude ?: "",
            cardType = binInfo.cardType,
            bankName = binInfo.bankName,
            bankUrl = binInfo.bankUrl,
            bankTel = binInfo.bankTel,
            bankCity = binInfo.bankCity,
        )
    }

    fun fromBinInfoApiToBinInfoDomain(bankInfoApi: BankInfoApi?): BinInfoDomain? {
        return bankInfoApi?.let { bankInfo ->
            val latitude = bankInfo.country?.latitude ?: ""
            val longitude = bankInfo.country?.longitude ?: ""
            val coordinates = if (latitude.isNotEmpty() && longitude.isNotEmpty()) {
                CoordinatesDomain(
                    latitude = latitude,
                    longitude = longitude,
                )
            } else {
                null
            }

            BinInfoDomain(
                country = bankInfo.country?.name ?: "",
                coordinates = coordinates,
                cardType = bankInfo.scheme ?: "",
                bankName = bankInfo.bank?.name ?: "",
                bankUrl = bankInfo.bank?.url ?: "",
                bankTel = bankInfo.bank?.phone ?: "",
                bankCity = bankInfo.bank?.city ?: "",
            )
        }
    }

    fun fromBankInfoEntityToBinInfoDomain(bankInfoEntity: BankInfoEntity?): BinInfoDomain? {
        return bankInfoEntity?.let { bankInfo ->
            BinInfoDomain(
                cardNumber = bankInfo.cardNumber,
                country = bankInfo.country,
                coordinates = CoordinatesDomain(
                    latitude = bankInfo.latitude,
                    longitude = bankInfo.longitude,
                ),
                cardType = bankInfo.cardType,
                bankName = bankInfo.bankName,
                bankUrl = bankInfo.bankUrl,
                bankTel = bankInfo.bankTel,
                bankCity = bankInfo.bankCity,
            )
        }
    }

    fun fromBankInfoEntityToBinInfoDomain(bankInfoEntity: List<BankInfoEntity>): List<BinInfoDomain> {
        return bankInfoEntity.map {
            BinInfoDomain(
                cardNumber = it.cardNumber,
                country = it.country,
                coordinates = CoordinatesDomain(
                    latitude = it.latitude,
                    longitude = it.longitude,
                ),
                cardType = it.cardType,
                bankName = it.bankName,
                bankUrl = it.bankUrl,
                bankTel = it.bankTel,
                bankCity = it.bankCity,
            )
        }
    }
}