package com.example.use_cases.user

import com.example.repository.AuthRepository

class GetAuthStateUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.getFirebaseAuthState()
}