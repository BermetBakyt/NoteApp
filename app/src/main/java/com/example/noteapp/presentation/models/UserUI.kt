package com.example.noteapp.presentation.models

import com.example.model.User

data class UserUI(
    val id: String,
    val name: String,
    val email: String,
    val password: String
)

fun User.toUserUI() = UserUI(
    id, name, email, password
)
