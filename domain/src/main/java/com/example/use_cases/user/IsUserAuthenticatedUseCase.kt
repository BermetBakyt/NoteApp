package com.example.use_cases.user

import com.example.repository.AuthRepository

class IsUserAuthenticatedUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.isUserAuthenticatedInFirebase()
}