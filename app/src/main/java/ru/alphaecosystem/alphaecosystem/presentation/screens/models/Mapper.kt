package ru.alphaecosystem.alphaecosystem.presentation.screens.models

import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

class Mapper {
    fun fromBinInfoDomainToBinInfo(binInfoDomain: BinInfoDomain): BinInfo {
        val latitude = binInfoDomain.coordinates?.latitude ?: ""
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

    fun fromBinInfoDomainToHistoryScreenState(binInfoDomain: List<BinInfoDomain>): List<BinInfo> {
        return binInfoDomain.map { binInfo ->
            val coordinates = binInfo.coordinates?.let { coord ->
                if (coord.latitude.isNotEmpty() && coord.longitude.isNotEmpty()) {
                    Coordinates(
                        latitude = coord.latitude,
                        longitude = coord.latitude,
                    )
                } else {
                    null
                }
            }
            BinInfo(
                cardNumber = binInfo.cardNumber,
                country = binInfo.country,
                coordinates = coordinates,
                cardType = binInfo.cardType,
                bankName = binInfo.bankName,
                bankUrl = binInfo.bankUrl,
                bankTel = binInfo.bankTel,
                bankCity = binInfo.bankCity,
            )
        }
    }

}