package com.example.seminar5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-genie-31a04.cloudfunctions.net/api/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val getNowService: GetNowService = retrofit.create(GetNowService::class.java)
}