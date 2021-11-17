package com.example.seminar5.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar5.databinding.ItemNowListBinding
import com.example.seminar5.ui.home.data.PopularityData

class NowAdapter : RecyclerView.Adapter<NowAdapter.NowViewHolder>(){
    val nowList = mutableListOf<PopularityData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NowViewHolder {
        val binding = ItemNowListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return NowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NowViewHolder, position: Int) {
        holder.onBind(nowList[position])
    }

    override fun getItemCount(): Int = nowList.size

    class NowViewHolder(private val binding: ItemNowListBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun onBind(data: PopularityData) {
                    binding.apply {
                        ivNowCover.setImageResource(data.cover)
                        tvNowRoomTitle.text=data.room_title
                        tvNowMusic.text=data.music_title + " - " + data.artist
                        tvNowUser.text=data.user_name
                        tvNowFanAmount.text=data.fan_amount
                        tvNowListenerAmount.text=data.listener_amount.toString()
                    }
                }
            }
}