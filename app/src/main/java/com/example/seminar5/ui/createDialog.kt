package com.example.seminar5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seminar5.databinding.ActivityCreateDialogBinding

class createDialog : AppCompatActivity() {
    private lateinit var binding: ActivityCreateDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}