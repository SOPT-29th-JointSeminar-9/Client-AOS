package com.example.seminar5.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar5.R
import com.example.seminar5.databinding.ItemPopularityListBinding
import com.example.seminar5.ui.home.data.ResponsePopularityData

class PopularityAdapter : RecyclerView.Adapter<PopularityAdapter.PopularityViewHolder>() {
    val popularityList = mutableListOf<ResponsePopularityData.Data>()

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
        fun onBind(data: ResponsePopularityData.Data) {

           if (data.id == 1) {
                binding.ivRanking.setImageResource(R.drawable.ic_ranking1)
            } else if (data.id == 10) {
                binding.ivRanking.setImageResource(R.drawable.ic_ranking2)
            } else if (data.id == 2) {
                binding.ivRanking.setImageResource(R.drawable.ic_ranking3)
            }

            binding.tvRoomTitle.text = data.hugTitle
            binding.tvUserName.text = data.nickname
            binding.tvFanAmount.text = data.fanCount.toString()
            binding.tvListenerAmount.text = data.listenerCount.toString()
            binding.tvMusicTitle.text = data.musicTitle
            binding.tvArtist.text = data.artist
            binding.ivCover.setImageURI(data.cover)
        }
    }
}