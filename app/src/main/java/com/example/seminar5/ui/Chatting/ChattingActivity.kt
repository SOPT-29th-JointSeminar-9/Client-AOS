package com.example.seminar5.ui.Chatting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.seminar5.databinding.ActivityChattingBinding

class ChattingActivity : AppCompatActivity() {
    private lateinit var chattingAdapter: ChatAdapter
    private lateinit var binding:ActivityChattingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityChattingBinding.inflate(layoutInflater)

        val input_edit = binding.etInput
        val send_tv = binding.tvSend

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

        setContentView(binding.root)
    }

    private fun initAdapter(){
    }


}