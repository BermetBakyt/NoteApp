package com.example.noteapp.presentation.ui.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.ui.fragments.login.FirebaseUserLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    val authenticationState = FirebaseUserLiveData().map { user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }
}