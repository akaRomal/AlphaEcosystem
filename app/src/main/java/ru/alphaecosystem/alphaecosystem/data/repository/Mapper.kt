package ru.alphaecosystem.alphaecosystem.data.repository

import ru.alphaecosystem.alphaecosystem.data.remote.models.BinInfoApi
import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain
import ru.alphaecosystem.alphaecosystem.domain.models.CoordinatesDomain

class Mapper() {
    fun fromBinInfoApiToBinInfoDomain(binInfoApi: BinInfoApi?): BinInfoDomain {
        val latitude = binInfoApi?.country?.latitude ?: ""
        val longitude = binInfoApi?.country?.longitude ?: ""
        val coordinates = if (latitude.isNotEmpty() && longitude.isNotEmpty()) {
            CoordinatesDomain(
                latitude = latitude,
                longitude = longitude,
            )
        } else {
            null
        }

        return BinInfoDomain(
            country = binInfoApi?.country?.name ?: "",
            coordinates = coordinates,
            cardType = binInfoApi?.scheme ?: "",
            bankName = binInfoApi?.bank?.name ?: "",
            bankUrl = binInfoApi?.bank?.url ?: "",
            bankTel = binInfoApi?.bank?.phone ?: "",
            bankCity = binInfoApi?.bank?.city ?: "",
        )
    }
}