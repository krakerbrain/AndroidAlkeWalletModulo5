package com.example.alkewalletmodulocinco.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alkewalletmodulocinco.R
import com.example.alkewalletmodulocinco.databinding.FragmentLoginSignUpBinding

class LoginSignUpFragment : Fragment() {

    private var _binding: FragmentLoginSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tieneCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginSignUpFragment_to_loginFragment)
        }

        binding.creaCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginSignUpFragment_to_signUpFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}