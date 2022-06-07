package com.example.repository

import com.example.Either
import com.example.Response
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val auth: FirebaseAuth
) : AuthRepository {

    override fun isUserAuthenticatedInFirebase() = auth.currentUser != null

    override suspend fun firebaseSignInAnonymously(): Flow<Either<String, Boolean>> = flow {
        try {
            emit(Either.Left)
            auth.signInAnonymously().await()
            emit(Response.Success(true))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }

    override suspend fun signOut() = flow {
        try {
            emit(Response.Loading)
            auth.currentUser?.delete()?.await()
            emit(Response.Success(true))
        } catch (e: Exception) {
            emit(Error(e.message ?: e.toString()))
        }
    }

    override fun getFirebaseAuthState() = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }
}
