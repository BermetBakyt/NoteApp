package com.example.repository

import com.example.Either
import com.example.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun registerUser(): Flow<Either<String, User>>

    fun loginUser(): Flow<Either<String, User>>

}