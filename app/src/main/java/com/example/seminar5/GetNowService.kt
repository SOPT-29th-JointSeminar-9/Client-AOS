package com.example.seminar5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface GetNowService {
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("radio/")
    fun getNowData(): Call<ResponseNowData>
}