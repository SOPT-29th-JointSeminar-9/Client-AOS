package com.example.seminar5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seminar5.R
import com.example.seminar5.databinding.ActivityMainBinding
import com.example.seminar5.ui.bottom.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

    }


    private fun initBottomNavigation() {
        val foryouFragment = ForyouFragment()
        val homeFragment = HomeFragment()
        val mymusicFragment = MymusicFragment()
        val searchFragment = SearchFragment()
        val menuFragment = MenuFragment()

        supportFragmentManager.beginTransaction().add(R.id.frg_container, homeFragment).commit()
        binding.bnvMenu.setOnItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (it.itemId) {
                R.id.menu_home -> {
                    transaction.replace(R.id.frg_container, homeFragment).commit()
                }

                R.id.menu_heart -> {
                    transaction.replace(R.id.frg_container, foryouFragment).commit()
                }

                R.id.menu_search -> {
                    transaction.replace(R.id.frg_container, searchFragment).commit()
                }

                R.id.menu_menu -> {
                    transaction.replace(R.id.frg_container, menuFragment).commit()
                }
                R.id.menu_mymusic -> {
                    transaction.replace(R.id.frg_container, mymusicFragment).commit()
                }

            }
            true





        }
    }



}