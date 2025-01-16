package ru.alphaecosystem.alphaecosystem.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity
import ru.alphaecosystem.alphaecosystem.data.local.entities.NewBankInfo

@Dao
interface BankInfoDao {

    @Query("SELECT * FROM ${BankInfoEntity.TABLE_NAME} ORDER BY ${BankInfoEntity.ID} ASC")
    fun getAll(): Flow<List<BankInfoEntity>>

    @Query(
        "SELECT * FROM ${BankInfoEntity.TABLE_NAME}" +
                " WHERE ${BankInfoEntity.CARD_NUMBER} = :number LIMIT 1"
    )
    fun findByNumber(number: String): BankInfoEntity

    @Query("DELETE FROM ${BankInfoEntity.TABLE_NAME} WHERE ${BankInfoEntity.CARD_NUMBER} = :number")
    fun delete(number: String)

    @Insert(entity = BankInfoEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(newBankInfo: NewBankInfo)
}