package com.example.seminar5.ui.home.di
import com.example.seminar5.ui.home.data.ResponsePopularityData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GetPopularityService {
    @Headers("Content-Type:application/json")
    @GET("/radio/popular")
    fun getPopularityData() : Call<ResponsePopularityData>

}