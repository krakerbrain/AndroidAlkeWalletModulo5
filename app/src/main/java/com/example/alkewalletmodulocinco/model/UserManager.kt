package com.example.alkewalletmodulocinco.model

import android.util.Log
import com.example.alkewalletmodulocinco.data.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("users")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
}
class UserManager{

    /**
     * agregar usuarios en duro
     */
    private val userList = mutableListOf<User>()
    fun addUser(user: User): Boolean {
        // Agregar usuario a la lista (simulando la inserción en una base de datos)
        userList.add(user)
        return true // Se puede agregar validaciones adicionales aquí si es necesario
    }

   fun register(request: RegisterRequest, callback: Callback<RegisterResponse> ){
        RetrofitClient.userService.register(request).enqueue(callback)
    }


}