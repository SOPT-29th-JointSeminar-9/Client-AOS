package com.example.seminar5.ui.home.data

import android.net.Uri

data class ResponsePopularityData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
    ) {
    data class Data(
        val id : Int,
        val hugTitle : String,
        val nickname : String,
        val fanCount : Int,
        val listenerCount : Int,
        val sentTime : String,
        val musicTitle : String,
        val artist : String,
        val cover : Uri
    )
}

