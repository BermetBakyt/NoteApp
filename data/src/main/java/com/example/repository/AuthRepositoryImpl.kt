package com.example.repository

import com.example.Either
import com.example.Response
import com.example.remote.dto.toUser
import com.example.remote.service.AuthService
import com.example.remote.service.FirestoreService
import com.example.repository.base.BaseRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val authService: AuthService
) : BaseRepository(), AuthRepository {

    override fun registerUser() = doRequest {
        authService.registerUser().toUser()
    }
}
