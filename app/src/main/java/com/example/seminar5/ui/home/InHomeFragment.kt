package com.example.seminar5.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar5.R
import com.example.seminar5.databinding.FragmentInhomeBinding

class InHomeFragment : Fragment() {
    private var _binding : FragmentInhomeBinding? = null
    private val binding get() = _binding ?: error("에러에러")
    private lateinit var tabViewPager: TabViewPager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentInhomeBinding.inflate(
          layoutInflater,
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