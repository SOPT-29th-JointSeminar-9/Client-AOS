package com.example.seminar5.ui

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
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
        //initProGressBar()

        initAnimation()

    }

   /* private fun initProGressBar(){





    }*/

    private fun initAnimation(){
        binding.progressbar.max = 1000

        ObjectAnimator.ofInt(binding.progressbar, "progress",1000)
            .setDuration(33000)
            .start()

        /*ObjectAnimator.ofFloat(binding.progressbar,"translationX", 100f).apply {
            duration = 30000
            binding.progressbar.progress  = 20
            start()
        }*/
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