package ru.alphaecosystem.alphaecosystem.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.alphaecosystem.alphaecosystem.data.local.dao.BankInfoDao
import ru.alphaecosystem.alphaecosystem.data.local.entities.BankInfoEntity

private const val DATABASE_NAME = "database"

@Database(entities = [BankInfoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bankInfoDao(): BankInfoDao
}

fun buildAppDatabase(applicationContext: Context): AppDatabase {
    return Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, DATABASE_NAME
    ).build()
}