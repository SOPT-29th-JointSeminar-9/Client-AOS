package com.example.seminar5

import com.example.seminar5.ui.home.data.RequestCreateHugData
import com.example.seminar5.ui.home.data.ResponseCreateHugData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostHugService {
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("radio/")
    fun postHug(
        @Body body: RequestCreateHugData
    ): Call<ResponseCreateHugData>
}