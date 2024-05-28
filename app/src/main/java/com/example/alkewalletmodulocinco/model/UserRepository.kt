package com.example.alkewalletmodulocinco.model

import com.example.alkewalletmodulocinco.data.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
class UserRepository {
    /**
     *Lógica para autenticar al usuario con datos en duro
     */
    fun login(user: User): Boolean {
        return (user.email == "j@gmail.com" && user.password == "123")
    }

    /**
     * Lógica para autenticar al usuario con Retrofit
     */
    fun login(request: LoginRequest, callback: Callback<LoginResponse>) {
        RetrofitClient.authService.login(request).enqueue(callback)
    }

}
