package ru.alphaecosystem.alphaecosystem.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alphaecosystem.alphaecosystem.BuildConfig
import ru.alphaecosystem.alphaecosystem.data.local.AppDatabase
import ru.alphaecosystem.alphaecosystem.data.local.buildAppDatabase
import ru.alphaecosystem.alphaecosystem.data.remote.BinApiService
import ru.alphaecosystem.alphaecosystem.data.repository.Mapper
import ru.alphaecosystem.alphaecosystem.data.repository.RepositoryImpl
import ru.alphaecosystem.alphaecosystem.domain.interfaces.Repository
import java.util.concurrent.TimeUnit

val dataModule = module{

    single<AppDatabase> { buildAppDatabase(applicationContext = get()) }

    single<Repository>{ RepositoryImpl(binApiService = get(), mapper = get())}

    single<Mapper> { Mapper() }

    single<BinApiService> { get<Retrofit>().create(BinApiService::class.java)  }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.ULR_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .build()
    }
}