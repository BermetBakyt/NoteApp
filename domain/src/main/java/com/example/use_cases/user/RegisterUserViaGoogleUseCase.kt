package com.example.use_cases.user

import com.example.repository.AuthRepository

class RegisterUserViaGoogleUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.registerUser()
}