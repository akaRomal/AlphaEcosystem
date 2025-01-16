package ru.alphaecosystem.alphaecosystem.presentation.screens.models

import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

class Mapper {
    fun fromBinInfoDomainToBinInfo(binInfoDomain: BinInfoDomain): BinInfo {
        return BinInfo(

            country = binInfoDomain.country,
            coordinates = Coordinates(
                latitude = binInfoDomain.coordinates?.latitude ?: "",
                longitude = binInfoDomain.coordinates?.longitude ?: "",
            ),
            cardType = binInfoDomain.cardType,
            bankName = binInfoDomain.bankName,
            bankUrl = binInfoDomain.bankUrl,
            bankTel = binInfoDomain.bankTel,
            bankCity = binInfoDomain.bankCity,
        )

    }
}