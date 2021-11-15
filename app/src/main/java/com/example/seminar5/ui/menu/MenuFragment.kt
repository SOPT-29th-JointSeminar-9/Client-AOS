package com.example.seminar5.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar5.R
import com.example.seminar5.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private var _binding : FragmentMenuBinding ?= null
    private val binding get() = _binding ?: error("뷰 참조를 위해 바인딩이 초기화되지 않음")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(
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