package com.example.alkewalletmodulocinco.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        // Inicializar el ViewModel de HomePageFragment
        homePageViewModel = ViewModelProvider(requireActivity())[HomePageViewModel::class.java]
        binding.loginBtn.setOnClickListener {
            binding.editTextEmail.text?.toString()?.let { userEmail ->
                binding.editTextPassword.text?.toString()?.let { userPassword ->
                    when (loginViewModel.login(userEmail, userPassword)) {
                        true -> {
                            // Obtener los datos del usuario del userLiveData
                            val userData = loginViewModel.userLiveData.value

                            // Verificar si los datos del usuario no son nulos
                            userData?.let {
//                                // Configurar los datos del usuario en el ViewModel de HomePageFragment
                                homePageViewModel.setUserData(it)

                                // Navegar al HomePageFragment
                                findNavController().navigate(R.id.action_loginFragment_to_homePageFragment)
                            } ?: run {
                                Toast.makeText(
                                    requireContext(),
                                    "Error: No se encontraron datos del usuario",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        false -> {
                            Log.d("LoginFragment", "Login failed")
                            Toast.makeText(
                                requireContext(),
                                "Credenciales inválidas",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }
        //    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.loginBtn.setOnClickListener {
//            val userEmail = binding.editTextEmail.text.toString()
//            val userPassword = binding.editTextPassword.text.toString()
//
//            if (loginViewModel.login(userEmail, userPassword)) {
//                // Log the initial value of userLiveData
//                Log.d("LoginFragment", "Initial userLiveData value: ${loginViewModel.userLiveData.value}")
//                findNavController().navigate(R.id.action_signAndLoginFragment_to_homePageFragment)
//
//            } else {
//                Log.d("LoginFragment", "Login failed")
//                Toast.makeText(requireContext(), "Credenciales inválidas", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
