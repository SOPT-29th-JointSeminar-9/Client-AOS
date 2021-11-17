package com.example.seminar5.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar5.R
import com.example.seminar5.databinding.FragmentDjchatBinding


class DjchatFragment : Fragment() {
    private var _binding : FragmentDjchatBinding?= null
    private val binding get() = _binding ?: error("뷰 참조를 위한 바인딩 실패")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentDjchatBinding.inflate(
           inflater,
           container,
           false
       )
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}