package com.example.seminar5.ui.home

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar5.R
import com.example.seminar5.databinding.FragmentInhomeBinding
import com.example.seminar5.ui.home.adapter.NowAdapter
import com.example.seminar5.ui.home.adapter.PopularityAdapter
import com.example.seminar5.ui.home.data.PopularityData

class InHomeFragment : Fragment() {
    private lateinit var popularityAdapter: PopularityAdapter
    private lateinit var nowAdapter: NowAdapter
    private var _binding: FragmentInhomeBinding? = null
    private val binding get() = _binding ?: error("에러에러")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInhomeBinding.inflate(
            layoutInflater,
            container,
            false
        )

        initPopularityAdapter()
        initNowAdapter()
        btnCreate()
        btnUp()

        return binding.root
    }

    private fun initPopularityAdapter() {
        popularityAdapter = PopularityAdapter()

        binding.rvPopularity.adapter = popularityAdapter

        popularityAdapter.popularityList.addAll(
            listOf(
                PopularityData(
                    R.drawable.img_popularity_cover1, 1, "낮잠", "실리카겔", "나른한 오후,\n" +
                            "햇살과 어울리는 음악\uD83C\uDF1E", "Mezinee", "35.4K", 985
                ),
                PopularityData(
                    R.drawable.img_popularity_cover2,
                    2,
                    "19",
                    "뎁트",
                    "학창시절을 떠올리게 \n하는 하이틴 노래모음",
                    "효린쓰",
                    "42K",
                    593
                ),
                PopularityData(
                    R.drawable.img_popularity_cover3,
                    3,
                    "Lemonade",
                    "NCT 127",
                    "밤샘작업\uD83D\uDCA6 하는 당신을\n" +
                            "위한 흥겨운 K-POP",
                    "강쥐가 세상을 구한다",
                    "13.7K",
                    426
                ),
                PopularityData(
                    R.drawable.img_popularity_cover4,
                    4,
                    "Big Love",
                    "검정치마 (The Black Skirts)",
                    "요즘 같은 날씨에\n" +
                            "듣기 좋은 감성플리\uD83C\uDFB6",
                    "햄버거시키지마라",
                    "52.9K",
                    321
                ),
                PopularityData(
                    R.drawable.img_popularity_cover5,
                    5,
                    "Sea Gets Hotter (Feat. Aar...",
                    "Durand Jones & The Indications",
                    "포근함을 \n" +
                            "노래로 만든다면",
                    "auaoavxx",
                    "8.2K",
                    112
                )
            )
        )
        popularityAdapter.notifyDataSetChanged()
    }

    private fun initNowAdapter() {
        nowAdapter = NowAdapter()

        binding.rvNow.adapter = nowAdapter

        nowAdapter.nowList.addAll(
            listOf(
                PopularityData(
                    R.drawable.img_now_cover1,
                    0,
                    "Savage",
                    "aespa",
                    "에스파 팬이라면 퍼가 ㅋ",
                    "에스파는나야둘이될수없어",
                    "29",
                    2
                ),
                PopularityData(
                    R.drawable.img_now_cover2,
                    0,
                    "새삼스럽게 왜",
                    "AKMU(악뮤)",
                    "음색깡패들과 함께 고막호강",
                    "hawonow",
                    "12",
                    5
                ),
                PopularityData(
                    R.drawable.img_now_cover3,
                    0,
                    "사람의 마음",
                    "장기하와 얼굴들",
                    "집으로 돌아가는 길, 노래 한 스푼",
                    "나의라임오지는나무",
                    "3",
                    1
                ),
                PopularityData(
                    R.drawable.img_now_cover4,
                    0,
                    "문득",
                    "BE'O(비오)",
                    "배가 고파서 밥\uD83C\uDF5A을 차렸는데",
                    "생갈치1호의행방불명",
                    "529",
                    32
                ),
                PopularityData(
                    R.drawable.img_now_cover5,
                    0,
                    "Island",
                    "10CM",
                    "타이틀만큼 좋은 수록곡 Playlist",
                    "danborii",
                    "0",
                    7
                ),
                PopularityData(
                    R.drawable.img_now_cover6,
                    0,
                    "미안해 (Feat. Beenzino)",
                    "Zion.T",
                    "사과를 할 때는 이 노래를 틀어주세요",
                    "oe9day",
                    "3",
                    84
                ),
                PopularityData(
                    R.drawable.img_now_cover7,
                    0,
                    "True Romance",
                    "Citizens!",
                    "우리가 사랑했던 \uD83C\uDFA7 OST",
                    "그대내게햄버거주는사람",
                    "0",
                    3
                )
            )
        )
        nowAdapter.notifyDataSetChanged()
    }

    private fun btnCreate(){
        binding.btnCreate.setOnClickListener{
            val DialogView = LayoutInflater.from(context).inflate(R.layout.fragment_create_dialog, null)
            val Builder = AlertDialog.Builder(context)
                .setView(DialogView)
            Builder.show()
        }
    }


    private fun btnUp() {
        binding.ivUp.setOnClickListener {
            binding.scrollview.scrollTo(0, binding.view.top)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}