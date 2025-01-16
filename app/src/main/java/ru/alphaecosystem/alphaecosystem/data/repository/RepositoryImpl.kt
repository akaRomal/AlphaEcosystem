package ru.alphaecosystem.alphaecosystem.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.alphaecosystem.alphaecosystem.data.local.dao.BankInfoDao
import ru.alphaecosystem.alphaecosystem.data.remote.BinApiService
import ru.alphaecosystem.alphaecosystem.domain.interfaces.Repository
import ru.alphaecosystem.alphaecosystem.domain.models.BinDomain
import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

class RepositoryImpl(
    private val binApiService: BinApiService,
    private val mapper: Mapper,
    private val bankInfoDao: BankInfoDao,
) : Repository {

    override suspend fun getBinInfo(binCard: BinDomain): BinInfoDomain? {
        return getBinInfoFromDb(binCard = binCard)
            .takeIf { dbBinInfo -> dbBinInfo != null }
            ?: try {
                getBinInfoFromApi(binCard = binCard)
                    .also { apiBinInfo ->
                        if (apiBinInfo != null) {
                            saveBinInfo(binInfo = apiBinInfo.copy(cardNumber = binCard.number))
                        }
                    }
            } catch (_: Exception) {
                null
            }
    }

    override suspend fun getBinInfoList(): Flow<List<BinInfoDomain>> {
        return bankInfoDao.getAll().map {
            with(mapper) {
                fromBankInfoEntityToBinInfoDomain(it)
            }
        }
    }

    override suspend fun deleteBin(binCard: BinDomain) {
        bankInfoDao.delete(number = binCard.number)
    }

    private suspend fun saveBinInfo(binInfo: BinInfoDomain) {
        with(mapper) {
            bankInfoDao.insert(fromBinInfoDomainToNewBankInfo(binInfo))
        }
    }

    private suspend fun getBinInfoFromApi(binCard: BinDomain): BinInfoDomain? {
        return with(mapper) {
            fromBinInfoApiToBinInfoDomain(binApiService.getBankInfo(bin = binCard.number))
        }
    }

    private suspend fun getBinInfoFromDb(binCard: BinDomain): BinInfoDomain? {
        return with(mapper) {
            fromBankInfoEntityToBinInfoDomain(bankInfoDao.findByNumber(number = binCard.number))
        }
    }
}