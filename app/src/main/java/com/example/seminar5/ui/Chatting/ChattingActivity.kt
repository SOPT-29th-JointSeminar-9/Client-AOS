package com.example.seminar5.ui.Chatting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.seminar5.databinding.ActivityChattingBinding
import com.example.seminar5.ui.Chatting.Data.ChatData
import com.example.seminar5.ui.Chatting.Data.MusicData
import com.example.seminar5.ui.Chatting.Data.ResponseMusicData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChattingActivity : AppCompatActivity() {
    private lateinit var mynewAdapter:MyNewAdapter
    private lateinit var musicAdapter: MusicAdapter
//    private lateinit var manager : LinearLayoutManager
    private lateinit var binding:ActivityChattingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityChattingBinding.inflate(layoutInflater)

        binding.clFloatingButton.bringToFront()

        val input_edit = binding.etInput
        val send_tv = binding.tvSend
        val recyclerView = binding.rvChat
//        recyclerView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
//            Log.v("test", "please1")
//
//            Log.v("test", "please2")
//            recyclerView.scrollToPosition(
//                recyclerView.getAdapter()!!.getItemCount() - 1
//            )
//
//        } 채팅할 때 쓰던거

//        manager = LinearLayoutManager(this)

        //initAdapter() 채팅

//        input_edit.onFocusChangeListener=View.OnFocusChangeListener{view, b->
//            if(b)
//                send_tv.setVisibility(View.VISIBLE)
//            else
//                send_tv.setVisibility(View.GONE)
//        }

        initMusicAdapter()



        // 텍스트가 하나라도 입력되면 전송버튼 띄우기, 입력된 텍스트 없으면 전송버튼 숨기기
        input_edit.addTextChangedListener{
            if(input_edit.text.length>0){
                send_tv.visibility=View.VISIBLE
            }
            else
                send_tv.visibility=View.GONE
        }
        send_tv.setOnClickListener{
//            mynewAdapter.chatList.add(ChatData(binding.etInput.text.toString()))
//            mynewAdapter.notifyDataSetChanged()

            initNetwork(binding.etInput.text.toString().toInt())
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

    private fun initMusicAdapter(){
        musicAdapter = MusicAdapter()
        binding.rvChat.adapter=musicAdapter
//        musicAdapter.musicList.addAll(
//            listOf(
//                MusicData("", "나의 어깨에 기대어요", "재생됩니다.", "오전 12:18")
//            )
//        )
        //musicAdapter.notifyDataSetChanged()
    }

    private fun initNetwork( num : Int) {
        val call: Call<ResponseMusicData> = MusicServiceCreater.musicService.getMusicData(num)

        call.enqueue(object : Callback<ResponseMusicData> {
            override fun onResponse(
                call: Call<ResponseMusicData>,
                response: Response<ResponseMusicData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("data", data.toString())
                    if(data != null){
                        musicAdapter.musicList.add(data.data)
                        musicAdapter.notifyDataSetChanged()
                    }

                    //Log.d("test", data.toString())
                    Toast.makeText(this@ChattingActivity, "서버연결성공", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ChattingActivity, "else로 실패", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseMusicData>, t: Throwable) {
                Log.d("failure", t.toString())
                Toast.makeText(this@ChattingActivity, "서버연결실패", Toast.LENGTH_SHORT).show()
            }
        })
    }
}