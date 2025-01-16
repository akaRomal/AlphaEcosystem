package ru.alphaecosystem.alphaecosystem.domain.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alphaecosystem.alphaecosystem.domain.models.BinDomain
import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

interface Repository {
    suspend fun getBinInfo(binCard: BinDomain):BinInfoDomain?
    suspend fun getBinInfoList(): Flow<List<BinInfoDomain>>
    suspend fun deleteBin(binCard: BinDomain)
}