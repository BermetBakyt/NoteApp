package com.example.remote.service

import com.example.remote.dto.UserDto

interface AuthService {

    //to do implement put data to firebase
    suspend fun registerUser() : UserDto

}