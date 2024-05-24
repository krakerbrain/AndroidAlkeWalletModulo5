package com.example.alkewalletmodulocinco.model

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val accessToken: String)

interface AuthService {
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}

object RetrofitClient {
    private const val BASE_URL = "http://wallet-main.eba-ccwdurgr.us-east-1.elasticbeanstalk.com/api/"

    val authService: AuthService by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            .create(AuthService::class.java)
    }
}

class UserRepository {
    fun login(user: User): Boolean {
        // Aquí iría la lógica para autenticar al usuario con datos en duro
        return (user.email == "j@gmail.com" && user.password == "123")
    }

    fun login(request: LoginRequest, callback: Callback<LoginResponse>) {
        RetrofitClient.authService.login(request).enqueue(callback)
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
