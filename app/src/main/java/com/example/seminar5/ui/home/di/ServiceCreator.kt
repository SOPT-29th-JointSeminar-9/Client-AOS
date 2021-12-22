package com.example.seminar5.ui.home.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-genie-31a04.cloudfunctions.net/api/"

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val getNowService: GetNowService = retrofit.create(GetNowService::class.java)
    val postHugService: PostHugService = retrofit.create(PostHugService::class.java)
    val getPopularityService : GetPopularityService = retrofit.create(GetPopularityService::class.java)
}