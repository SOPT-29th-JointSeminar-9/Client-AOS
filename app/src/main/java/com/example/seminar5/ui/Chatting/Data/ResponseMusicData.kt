package com.example.seminar5.ui.Chatting.Data

data class ResponseMusicData(
    val status : Int,
    val success: Boolean,
    val message : String,
    val data : Data
){
    data class Data(
        val id : Int,
        val hugTitle : String,
        val nickname : String,
        val fancount : Int,
        val listenerCount : Int,
        val sentTime : String,
        val musicTitle : String,
        val artist : String,
        val cover : String
    )
}
