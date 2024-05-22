package com.example.alkewalletmodulocinco.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletmodulocinco.model.User

class HomePageViewModel: ViewModel() {
    private val _userData = MutableLiveData<User>()
    val userData: LiveData<User> get() = _userData

    fun setUserData(user: User) {
        _userData.value = user
    }
}