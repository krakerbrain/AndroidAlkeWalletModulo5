package com.example.alkewalletmodulocinco.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletmodulocinco.model.User
import com.example.alkewalletmodulocinco.model.UserRepository
import com.example.alkewalletmodulocinco.model.LoginRequest
import com.example.alkewalletmodulocinco.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()
    private val _userLiveData = MutableLiveData<User?>()
    val userLiveData: LiveData<User?> get() = _userLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    private var isDevelopmentMode = true // Variable para cambiar entre modo desarrollo y real

    fun login(email: String, password: String) {
        if (!isEmailValid(email)) {
            _errorLiveData.value = "Correo electrónico inválido"
            return
        }

        if (isDevelopmentMode) {
            loginWithHardcodedData(email, password)
        } else {
            loginWithApi(email, password)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun loginWithHardcodedData(email: String, password: String) {
        val user = User("Juan", "Perez", email, password, 1, 100) // Datos de usuario de prueba
        val isLoggedIn = userRepository.login(user)

        if (isLoggedIn) {
            _userLiveData.value = user
        } else {
            _userLiveData.value = null
            _errorLiveData.value = "Credenciales inválidas"
        }
    }

    private fun loginWithApi(email: String, password: String) {
        val loginRequest = LoginRequest(email, password)
        userRepository.login(loginRequest, object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val user = User("Juan", "Perez", email, password, 1, 100) // Ajusta según respuesta real
                    _userLiveData.value = user
                } else {
                    _errorLiveData.value = "Credenciales inválidas"
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _errorLiveData.value = "Error de red: ${t.message}"
            }
        })
    }

    fun logout() {
        _userLiveData.value = null
    }
}
