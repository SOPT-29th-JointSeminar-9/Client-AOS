package com.example.seminar5.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.seminar5.ui.home.di.ServiceCreator
import com.example.seminar5.databinding.FragmentCreateDialogBinding
import com.example.seminar5.ui.Chatting.ChattingActivity
import com.example.seminar5.ui.home.data.RequestCreateHugData
import com.example.seminar5.ui.home.data.ResponseCreateHugData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateDialogFragment : DialogFragment() {
    private var _binding: FragmentCreateDialogBinding? = null
    private val binding get() = _binding ?: error("에러에러")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateDialogBinding.inflate(
            layoutInflater,
            container,
            false
        )

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        binding.btnListen.setOnClickListener {
            initPostNetwork()
            val intent = Intent(requireContext(), ChattingActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    fun initPostNetwork(){
        val requestCreateHugData = RequestCreateHugData(
            hugTitle = binding.etInputRoomName.text.toString(),
            nickname = binding.etNickname.text.toString()
        )

        val call: Call<ResponseCreateHugData> = ServiceCreator.postHugService.postHug(requestCreateHugData)

        call.enqueue(object : Callback<ResponseCreateHugData> {
            override fun onResponse(
                call: Call<ResponseCreateHugData>,
                response: Response<ResponseCreateHugData>
            ) {
                if(response.isSuccessful){
                    Log.d("뮤직허그 생성 성공", response.body()?.status.toString() + response.body()?.success.toString()+ response.body()?.message)
                }
                else {
                    Log.d("뮤직허그 생성 실패", "error"+ response.code().toString()+"\n\n"+ response.message()+"\n\n"+response.errorBody()+"\n\n"+response.headers())
                }
            }

            override fun onFailure(call: Call<ResponseCreateHugData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}