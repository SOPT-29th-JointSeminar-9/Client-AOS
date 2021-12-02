package com.example.seminar5.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seminar5.ResponseNowData
import com.example.seminar5.databinding.ItemNowListBinding

class NowAdapter : RecyclerView.Adapter<NowAdapter.NowViewHolder>(){
    val nowList = mutableListOf<ResponseNowData.Object>()

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
                fun onBind(data: ResponseNowData.Object) {
                    binding.apply {
                        Glide.with(ivNowCover) //여기는 context 쓰는 자리라 꼭 ivNowCover가 안 들어가도됨
                            .load(data.cover)
                            .into(binding.ivNowCover) //여기는 진짜로 들어갈 자리
                        //ivNowCover.setImageURI(data.cover)
                        tvNowRoomTitle.text=data.hugTitle
                        tvNowMusic.text=data.musicTitle + " - " + data.artist
                        tvNowUser.text=data.nickname
                        tvNowFanAmount.text=data.fanCount
                        tvNowListenerAmount.text=data.listenerCount.toString()
                    }
                }
            }
}