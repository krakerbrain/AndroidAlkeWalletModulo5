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
import com.example.alkewalletmodulocinco.databinding.FragmentSignUpBinding
import com.example.alkewalletmodulocinco.model.User
import com.example.alkewalletmodulocinco.viewmodel.SignUpViewModel


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.creaCuenta.setOnClickListener {
            val user = getUserFromInputFields()
            if (user != null) {
                if (signUpViewModel.signUp(user)) {
                    // Registro exitoso
                    Toast.makeText(requireContext(), "Registro exitoso", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                } else {
                    // Error en el registro
                    Toast.makeText(requireContext(), "Error en el registro", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Error en los datos ingresados por el usuario
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tieneCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

    }

    private fun getUserFromInputFields(): User? {
        val nombre = binding.includeSignupForm.editNombreInput.text.toString()
        val apellido = binding.includeSignupForm.editApellidoInput.text.toString()
        val email = binding.includeSignupForm.editEmailInput.text.toString()
        val password = binding.includeSignupForm.editPassInput.text.toString()
        val confirmPassword = binding.includeSignupForm.editConfirmPassInput.text.toString()

        // Devolver un objeto User con los datos ingresados por el usuario si son válidos
        return if (nombre.isNotEmpty() && apellido.isNotEmpty() && email.isNotEmpty() &&
            password.isNotEmpty() && confirmPassword.isNotEmpty() && password == confirmPassword) {
            User(nombre, apellido, email, password,0,0)
        } else {
            null
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}