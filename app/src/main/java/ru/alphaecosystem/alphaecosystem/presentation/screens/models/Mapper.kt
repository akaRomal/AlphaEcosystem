package ru.alphaecosystem.alphaecosystem.presentation.screens.models

import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

class Mapper {
    fun fromBinInfoDomainToBinInfo(binInfoDomain: BinInfoDomain): BinInfo {
        val latitude =binInfoDomain.coordinates?.latitude ?: ""
        val longitude = binInfoDomain.coordinates?.longitude ?: ""
        val coordinates = if (latitude.isNotEmpty() && longitude.isNotEmpty()) {
            Coordinates(
                latitude = latitude,
                longitude = longitude,
            )
        } else {
            null
        }

        return BinInfo(
            country = binInfoDomain.country,
            coordinates = coordinates,
            cardType = binInfoDomain.cardType,
            bankName = binInfoDomain.bankName,
            bankUrl = binInfoDomain.bankUrl,
            bankTel = binInfoDomain.bankTel,
            bankCity = binInfoDomain.bankCity,
        )
    }
}