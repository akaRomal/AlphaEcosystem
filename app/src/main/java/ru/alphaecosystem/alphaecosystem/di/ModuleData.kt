package ru.alphaecosystem.alphaecosystem.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alphaecosystem.alphaecosystem.BuildConfig
import ru.alphaecosystem.alphaecosystem.data.remote.BinApiService
import java.util.concurrent.TimeUnit

val dataModule = module{

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