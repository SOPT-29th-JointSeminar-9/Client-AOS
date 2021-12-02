package com.example.seminar5.ui.Chatting

import com.example.seminar5.ui.Chatting.Data.ResponseMusicData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MusicService {
    //@Headers("Content-Type:application/x-www-form-urlencoded")
    @Headers("Content-Type: application/json")

    @GET("radio/{id}")
    fun getMusicData(@Path("id") id : Int): Call<ResponseMusicData>
}