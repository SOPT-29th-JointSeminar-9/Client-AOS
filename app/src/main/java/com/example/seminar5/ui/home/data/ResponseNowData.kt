package com.example.seminar5.ui.home.data

data class ResponseNowData(
    val status: Number,
    val success: String,
    val message: String,
    val data: List<Object>
) {
    data class Object(
        val id: Int,
        val hugTitle: String,
        val nickname: String,
        val fanCount: String,
        val listenerCount: Int,
        val sentTime: String,
        val musicTitle: String,
        val artist: String,
        val cover: String
    )
}