package com.example.seminar5.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar5.R
import com.example.seminar5.databinding.FragmentInhomeBinding
import com.example.seminar5.ui.home.adapter.PopularityAdapter
import com.example.seminar5.ui.home.data.PopularityData

class InHomeFragment : Fragment() {
    private lateinit var popularityAdapter: PopularityAdapter
    private var _binding: FragmentInhomeBinding? = null
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

        initAdapter()

        return binding.root
    }


    private fun initAdapter() {
        popularityAdapter = PopularityAdapter()

        binding.rvPopularity.adapter=popularityAdapter

        popularityAdapter.popularityList.addAll(
            listOf(
                PopularityData(R.drawable.img_popularity_cover1,1,"낮잠","실리카겔","나른한 오후,\n" +
                        "햇살과 어울리는 음악\uD83C\uDF1E","Mezinee","35.4K",985),
                PopularityData(R.drawable.img_popularity_cover2,2,"19","뎁트","학창시절을 떠올리게 \n하는 하이틴 노래모음","효린쓰","42K",593),
                PopularityData(R.drawable.img_popularity_cover3,3,"Lemonade","NCT 127","밤샘작업\uD83D\uDCA6 하는 당신을\n" +
                        "위한 흥겨운 K-POP","강쥐가 세상을 구한다","13.7K",426),
                PopularityData(R.drawable.img_popularity_cover4,4,"Big Love","검정치마 (The Black Skirts)","요즘 같은 날씨에\n" +
                        "듣기 좋은 감성플리\uD83C\uDFB6","햄버거시키지마라","52.9K",321),
                PopularityData(R.drawable.img_popularity_cover5,5,"Sea Gets Hotter (Feat. Aar...","Durand Jones & The Indications","포근함을 \n" +
                        "노래로 만든다면","auaoavxx","8.2K", 112)
            )
        )
        popularityAdapter.notifyDataSetChanged()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}