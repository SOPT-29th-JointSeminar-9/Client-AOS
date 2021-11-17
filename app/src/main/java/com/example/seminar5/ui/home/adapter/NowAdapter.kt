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

    override fun onBindViewHolder(holder: NowAdapter.NowViewHolder, position: Int) {
        holder.onBind(nowList[position])
    }

    override fun getItemCount(): Int = nowList.size

    class NowViewHolder(private val binding: ItemNowListBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun onBind(data: PopularityData) {
                    binding.apply {
                        ivNowCover.setImageResource(data.cover)
                        tvNowRoomTitle.setText(data.room_title)
                        tvNowMusic.setText(data.music_title + " - " + data.artist)
                        tvNowUser.setText(data.user_name)
                        tvNowFanAmount.setText(data.fan_amount)
                        tvNowListenerAmount.setText(data.listener_amount)
                    }
                }
            }
}