package com.example.seminar5.ui.Chatting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seminar5.databinding.MusichugBubbleShapeBinding
import com.example.seminar5.ui.Chatting.Data.MusicData
import com.example.seminar5.ui.Chatting.Data.ResponseMusicData

class MusicAdapter : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    val musicList = mutableListOf<ResponseMusicData.Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = MusichugBubbleShapeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.onBind(musicList[position])
    }

    override fun getItemCount(): Int = musicList.size

    class MusicViewHolder(private val binding: MusichugBubbleShapeBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun onBind(data:ResponseMusicData.Data){
            binding.tvTimestamp.text = data.sentTime
            binding.tvMusic.text = data.musicTitle + "-" + data.artist
            binding.tvMusicPlay.text = "재생됩니다."
            Glide.with(binding.root).load(data.cover).into(binding.ivMusicHug)
        }
    }
}