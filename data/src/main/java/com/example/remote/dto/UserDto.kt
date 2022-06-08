package com.example.remote.dto

import com.example.model.User

data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val password: String
)

fun UserDto.toUser() = User(
    id, name, email, password
)