package com.example.use_cases.user

import com.example.repository.AuthRepository

class SignInAnonymouslyUseCase(
    private val repository: AuthRepository
) {
    suspend fun invoke() = repository.firebaseSignInAnonymously()
}