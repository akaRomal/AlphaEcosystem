package ru.alphaecosystem.alphaecosystem.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.alphaecosystem.alphaecosystem.data.remote.models.BinInfoApi

interface BinApiService {
    @Headers("Accept: application/json")
    @GET("{bin}")
    fun getBankInfo(
        @Path("bin") bin: String
    ): Call<BinInfoApi>
}