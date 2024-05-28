package com.example.alkewalletmodulocinco.model

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val roleId: Int = 1,
    val points: Int = 1000
)
