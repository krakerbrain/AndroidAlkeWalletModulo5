package com.example.alkewalletmodulocinco.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alkewalletmodulocinco.R
import com.example.alkewalletmodulocinco.databinding.FragmentLoginBinding
import com.example.alkewalletmodulocinco.viewmodel.HomePageViewModel
import com.example.alkewalletmodulocinco.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var homePageViewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homePageViewModel = ViewModelProvider(requireActivity())[HomePageViewModel::class.java]

        binding.loginBtn.setOnClickListener {
            val userEmail = binding.editTextEmail.text?.toString() ?: ""
            val userPassword = binding.editTextPassword.text?.toString() ?: ""

            loginViewModel.login(userEmail, userPassword)
        }

        loginViewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            user?.let {
                homePageViewModel.setUserData(it)
                findNavController().navigate(R.id.action_loginFragment_to_homePageFragment)
            }
        }

        loginViewModel.errorLiveData.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
