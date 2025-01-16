package ru.alphaecosystem.alphaecosystem.data.repository

import kotlinx.coroutines.flow.Flow
import ru.alphaecosystem.alphaecosystem.data.remote.BinApiService
import ru.alphaecosystem.alphaecosystem.domain.interfaces.Repository
import ru.alphaecosystem.alphaecosystem.domain.models.BinDomain
import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

class RepositoryImpl(private val binApiService: BinApiService, private val mapper: Mapper): Repository {
    override suspend fun getBinInfo(binCard: BinDomain): BinInfoDomain {
        return getBinInfoFromApi(binCard)
    }

    override suspend fun getBinInfoList(): Flow<List<BinInfoDomain>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBin(binCard: BinDomain): Boolean {
        TODO("Not yet implemented")
    }

    private suspend fun getBinInfoFromApi(binCard: BinDomain):BinInfoDomain{
        return with(mapper) {
            fromBinInfoApiToBinInfoDomain(binApiService.getBankInfo(bin = binCard.number))
        }
    }
}