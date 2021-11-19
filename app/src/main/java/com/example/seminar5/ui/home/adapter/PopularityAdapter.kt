package com.example.seminar5.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar5.R
import com.example.seminar5.databinding.ItemPopularityListBinding
import com.example.seminar5.ui.home.data.PopularityData

class PopularityAdapter : RecyclerView.Adapter<PopularityAdapter.PopularityViewHolder>() {
    val popularityList = mutableListOf<PopularityData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularityViewHolder {
        val binding = ItemPopularityListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return PopularityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularityViewHolder, position: Int) {
        holder.onBind(popularityList[position])
    }

    override fun getItemCount(): Int = popularityList.size

    class PopularityViewHolder(private val binding: ItemPopularityListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: PopularityData) {
            binding.ivCover.setImageResource(data.cover)
            if (data.ranking == 1) {
                binding.ivRanking.setImageResource(R.drawable.ic_ranking1)
            } else if (data.ranking == 2) {
                binding.ivRanking.setImageResource(R.drawable.ic_ranking2)
            } else if (data.ranking == 3) {
                binding.ivRanking.setImageResource(R.drawable.ic_ranking3)
            }
            binding.tvMusicTitle.text = data.music_title
            binding.tvArtist.text = data.artist
            binding.tvRoomTitle.text = data.room_title
            binding.tvFanAmount.text = data.fan_amount
            binding.tvListenerAmount.text = data.listener_amount.toString()
            binding.tvUserName.text = data.user_name

        }
    }
}