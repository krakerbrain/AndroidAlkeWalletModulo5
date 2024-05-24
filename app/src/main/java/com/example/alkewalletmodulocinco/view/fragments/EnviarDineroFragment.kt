package com.example.alkewalletmodulocinco.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alkewalletmodulocinco.R
import com.example.alkewalletmodulocinco.databinding.FragmentEnviarDineroBinding
import com.example.alkewalletmodulocinco.databinding.FragmentHomePageBinding


class EnviarDineroFragment : Fragment() {

    private var _binding: FragmentEnviarDineroBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEnviarDineroBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.irAtras.setOnClickListener {
            findNavController().navigateUp()
        }


    }


}