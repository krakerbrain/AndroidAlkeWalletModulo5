package com.example.alkewalletmodulocinco.model

import android.util.Log

class UserRepository {

    fun login(user: User): Boolean {
        // Aquí iría la lógica para autenticar al usuario
        return (user.email == "juan" && user.password == "123")
    }

    private val userList = mutableListOf<User>()

    fun addUser(user: User): Boolean {
        // Agregar usuario a la lista (simulando la inserción en una base de datos)
        userList.add(user)
        // Loguear los datos del usuario que llegan a la función addUser
        Log.d("UserRepository", "Datos del usuario recibidos: $userList")
        return true // Se puede agregar validaciones adicionales aquí si es necesario
    }
}