package com.example.alkewalletmodulocinco.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.alkewalletmodulocinco.model.LoginRequest
import com.example.alkewalletmodulocinco.model.LoginResponse
import com.example.alkewalletmodulocinco.model.RegisterRequest
import com.example.alkewalletmodulocinco.model.RegisterResponse
import com.example.alkewalletmodulocinco.model.User
import com.example.alkewalletmodulocinco.model.UserManager
import com.example.alkewalletmodulocinco.model.UserRepository
import com.example.alkewalletmodulocinco.util.AppConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {
    private val userManager = UserManager()

    fun signUp(user: User) {
        // Realizar validaciones de datos aquí
        if (!validateUserData(user)) {
            return
        }

        if (AppConfig.isDevelopmentMode) {
            signUpWithHardcodedData(user)
        } else {
            signUpWithApi(user)
        }
    }


    private fun signUpWithHardcodedData(user: User): Boolean {
        return userManager.addUser(user)
    }

    private fun signUpWithApi(user: User) {
        val registerRequest =
            RegisterRequest(user.firstName, user.lastName, user.email, user.password, 1, 1000)
        userManager.register(registerRequest, object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {

                    // Registro exitoso
                    // Manejar la respuesta del servidor según sea necesario
                } else {
                    // Error en el registro
                    // Manejar el error según sea necesario
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                // Error en la solicitud
                // Manejar el error según sea necesario
            }
        })
    }

    private fun validateUserData(user: User): Boolean {
        // Verificar que no haya campos vacíos
        if (user.firstName.isEmpty() || user.lastName.isEmpty() || user.email.isEmpty() || user.password.isEmpty()) {
            return false
        }

        // Verificar el formato del correo electrónico
        if (!Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) {
            return false
        }

        // Si todas las validaciones pasan, devolver true
        return true
    }
}