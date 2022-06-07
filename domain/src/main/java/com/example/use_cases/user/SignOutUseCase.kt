package com.example.use_cases.user

import com.example.repository.AuthRepository

class SignOutUseCase(
    private val repository: AuthRepository
) {
    suspend fun invoke() = repository.signOut()
}