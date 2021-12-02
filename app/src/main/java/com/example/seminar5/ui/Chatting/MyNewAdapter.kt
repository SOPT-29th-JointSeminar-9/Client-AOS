package com.example.seminar5.ui.Chatting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar5.databinding.MychatBubbleShapeBinding
import com.example.seminar5.ui.Chatting.Data.ChatData

class MyNewAdapter:RecyclerView.Adapter<MyNewAdapter.MyNewViewHolder>() {
    val chatList = mutableListOf<ChatData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNewViewHolder {
        val binding = MychatBubbleShapeBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return MyNewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyNewViewHolder, position: Int) {
        holder.onBind(chatList[position])
    }

    override fun getItemCount(): Int = chatList.size

    class MyNewViewHolder(private val binding: MychatBubbleShapeBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun onBind(data: ChatData){
                binding.tvMyMessage.text=data.chat
            }
        }


}