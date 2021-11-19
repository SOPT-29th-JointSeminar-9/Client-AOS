package com.example.seminar5.ui.Chatting

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar5.databinding.MychatBubbleShapeBinding
import com.example.seminar5.databinding.OtherchatBubbleShapeBinding
import com.example.seminar5.ui.Chatting.MessageItemUi.Companion.TYPE_FRIEND_MESSAGE
import com.example.seminar5.ui.Chatting.MessageItemUi.Companion.TYPE_MY_MESSAGE
import java.lang.IllegalArgumentException

class ChatAdapter(var data: MutableList<MessageItemUi>) : RecyclerView.Adapter<MessageViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder<*> {
        val binding1 = MychatBubbleShapeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding2 = OtherchatBubbleShapeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return when(viewType){
            TYPE_MY_MESSAGE->{
                MyMessageViewHolder(binding1)
            }
            TYPE_FRIEND_MESSAGE->{
                FriendMessageViewHolder(binding2)
            }
            else->throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder<*>, position: Int) {
        val item = data[position]
        Log.d("adapter View", position.toString() + item.content)
        when (holder) {
            is MyMessageViewHolder -> holder.bind(item)
            is FriendMessageViewHolder -> holder.bind(item)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = data[position].messageType

    class MyMessageViewHolder(private val binding: MychatBubbleShapeBinding): MessageViewHolder<MessageItemUi>(binding.root){
        override fun bind(item: MessageItemUi) {
            binding.tvMyMessage.text=item.content
            binding.tvMyMessage.setTextColor(item.textColor)
        }
    }

    class FriendMessageViewHolder(private val binding: OtherchatBubbleShapeBinding):MessageViewHolder<MessageItemUi>(binding.root){
        override fun bind(item: MessageItemUi) {
            binding.tvOtherMessage.text=item.content
            binding.tvOtherMessage.setTextColor(item.textColor)
        }
    }

}