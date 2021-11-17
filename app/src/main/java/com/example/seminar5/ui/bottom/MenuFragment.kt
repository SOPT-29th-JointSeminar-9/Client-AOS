package com.example.seminar5.ui.bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar5.R
import com.example.seminar5.databinding.FragmentInhomeBinding
import com.example.seminar5.databinding.FragmentMenuBinding
import com.example.seminar5.ui.home.DjchatFragment
import com.example.seminar5.ui.home.FriendFragment
import com.example.seminar5.ui.home.InHomeFragment
import com.example.seminar5.ui.home.TabViewPager
import com.google.android.material.tabs.TabLayoutMediator


class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding ?: error("뷰 참조를 위해 바인딩이 초기화되지 않음")
    private lateinit var tabViewPager: TabViewPager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(
            inflater,
            container,
            false
        )

        initAdapter()
        initTabLayout()
        return binding.root


    }


    private fun initAdapter() {
        val fragmentList = listOf(InHomeFragment(), DjchatFragment(), FriendFragment())

        tabViewPager = TabViewPager(this)
        tabViewPager.fragments.addAll(fragmentList)

        binding.vpTop.adapter = tabViewPager
        binding.vpTop.isSaveEnabled = false
    }


    private fun initTabLayout() {

        val tabLabel = listOf("홈", "DJ차트", "친구")
//R.string.home,R.string.djchat,R.string.friend
        TabLayoutMediator(binding.tlTop, binding.vpTop) {

                tab, position ->
            tab.text = tabLabel[position]
        }.attach()

        binding.vpTop.isUserInputEnabled = false // swipe 막기
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}