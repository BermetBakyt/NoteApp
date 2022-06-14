package com.example.noteapp.presentation.ui.fragments.login

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseUserLiveData : LiveData<FirebaseUser?>() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    // слушатель, который будет подписан на события current user
    private val authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
        value = firebaseAuth.currentUser
    }

    // метод onActive будет вызван, если есть подписчик. эти методы позволяют отключать
    // или подключать слушатель

    override fun onActive() {
        firebaseAuth.addAuthStateListener(authStateListener)
    }
    // если нет подписчиков, будет вызван onInactive
    override fun onInactive() {
        firebaseAuth.removeAuthStateListener(authStateListener)
    }
}