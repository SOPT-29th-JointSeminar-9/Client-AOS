package com.example.seminar5.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.seminar5.R
import com.example.seminar5.ui.home.data.ResponseNowData
import com.example.seminar5.ServiceCreator
import com.example.seminar5.databinding.FragmentInhomeBinding
import com.example.seminar5.ui.CreateDialogFragment
import com.example.seminar5.ui.home.adapter.NowAdapter
import com.example.seminar5.ui.home.adapter.PopularityAdapter
import com.example.seminar5.ui.home.data.PopularityData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        initNowAdapter() //Adapter가 먼저 초기화된 상태에서 
        initNowNetwork() //네트워크 연결해야함
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
        nowAdapter = NowAdapter() //Adapter 초기화
        binding.rvNow.adapter = nowAdapter
    }

    private fun initNowNetwork() {
        val call: Call<ResponseNowData> =
            ServiceCreator.getNowService.getNowData()

        call.enqueue(object : Callback<ResponseNowData> {
            override fun onResponse(
                call: Call<ResponseNowData>,
                response: Response<ResponseNowData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        nowAdapter.nowList.addAll(data.data)
                        nowAdapter.notifyDataSetChanged() //Adapter에 값이 바뀔 때 바로 호출하는 것이 좋음
                        binding.tvNowCnt.setText(data.data.size.toString())
                    } else { }
                } else {
                    Log.d("fail", response?.message())
                }
            }

            override fun onFailure(call: Call<ResponseNowData>, t: Throwable) {
                //에러 처리
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
                Log.e("NetworkTest", "error:$t")
            }

        })
    }

    private fun btnCreate() {
        binding.btnCreate.setOnClickListener {
            CreateDialogFragment().show(childFragmentManager, "")
        }
    }


    private fun btnUp() {
        binding.ivUp.setOnClickListener {
            binding.scrollview.smoothScrollTo(0, binding.view.top)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}