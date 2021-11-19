package com.example.seminar5.ui.Chatting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seminar5.databinding.ActivityChattingBinding

class ChattingActivity : AppCompatActivity() {
    private lateinit var mynewAdapter:MyNewAdapter
//    private lateinit var manager : LinearLayoutManager
    private lateinit var binding:ActivityChattingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityChattingBinding.inflate(layoutInflater)

        binding.clFloatingButton.bringToFront()

        val input_edit = binding.etInput
        val send_tv = binding.tvSend
        val recyclerView = binding.rvChat
        recyclerView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            Log.v("test", "please1")

            Log.v("test", "please2")
            recyclerView.scrollToPosition(
                recyclerView.getAdapter()!!.getItemCount() - 1
            )

        }
//        manager = LinearLayoutManager(this)


        initAdapter()
//        input_edit.onFocusChangeListener=View.OnFocusChangeListener{view, b->
//            if(b)
//                send_tv.setVisibility(View.VISIBLE)
//            else
//                send_tv.setVisibility(View.GONE)
//        }
        // 텍스트가 하나라도 입력되면 전송버튼 띄우기, 입력된 텍스트 없으면 전송버튼 숨기기

        input_edit.addTextChangedListener{
            if(input_edit.text.length>0){
                send_tv.visibility=View.VISIBLE
            }
            else
                send_tv.visibility=View.GONE
        }
        send_tv.setOnClickListener{
            mynewAdapter.chatList.add(ChatData(binding.etInput.text.toString()))
            mynewAdapter.notifyDataSetChanged()
            input_edit.text=null
        }

        setContentView(binding.root)
    }

    private fun initAdapter(){
        mynewAdapter = MyNewAdapter()

//        manager.stackFromEnd=true
//        binding.rvChat.layoutManager=manager
//        binding.rvChat.setAdapter(mynewAdapter)

        binding.rvChat.adapter=mynewAdapter

//        manager.reverseLayout=true




    }


}