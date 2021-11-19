package com.example.seminar5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.seminar5.R
import com.example.seminar5.databinding.FragmentCreateDialogBinding
import com.example.seminar5.databinding.FragmentInhomeBinding

class CreateDialogFragment : DialogFragment() {
    private var _binding: FragmentCreateDialogBinding? = null
    private val binding get() = _binding ?: error("에러에러")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateDialogBinding.inflate(
            layoutInflater,
            container,
            false
        )

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        binding.btnListen.setOnClickListener {
            //TODO : 채팅방과 연결해야 함
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}