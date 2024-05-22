package com.example.alkewalletmodulocinco.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletmodulocinco.model.User
import com.example.alkewalletmodulocinco.model.UserRepository

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val _userLiveData = MutableLiveData<User?>()
    val userLiveData: LiveData<User?> get() = _userLiveData

    fun login(email: String, password: String): Boolean {
        val user = User("Juan", "Perez", email, password, 1, 100) // Datos de usuario de prueba
        val isLoggedIn = userRepository.login(user)

        if (isLoggedIn) {
            _userLiveData.value = user

        } else {
            _userLiveData.value = null

        }
        return isLoggedIn
    }

    fun logout() {
        _userLiveData.value = null
    }
}
