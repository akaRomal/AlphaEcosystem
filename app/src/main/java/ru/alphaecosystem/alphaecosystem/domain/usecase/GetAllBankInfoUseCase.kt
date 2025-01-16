package ru.alphaecosystem.alphaecosystem.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.alphaecosystem.alphaecosystem.domain.interfaces.Repository
import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

class GetAllBankInfoUseCase(private val repository: Repository) {
    suspend fun execute(): Flow<List<BinInfoDomain>> {
        return repository.getBinInfoList()
    }
}