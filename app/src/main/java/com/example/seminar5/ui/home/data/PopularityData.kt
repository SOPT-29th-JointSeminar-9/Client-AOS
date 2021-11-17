package com.example.seminar5.ui.home.data

data class PopularityData(
    val cover: Int,
    val ranking: Int, //1,2,3일 때만 ranking img 띄우기
    val music_title: String,
    val artist: String,
    val room_title: String,
    val user_name: String,
    val fan_amount: String,
    val listener_amount: Int
)
