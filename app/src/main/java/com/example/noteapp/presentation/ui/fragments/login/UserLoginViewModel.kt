package com.example.noteapp.presentation.ui.fragments.login

import androidx.lifecycle.map
import com.example.noteapp.presentation.base.BaseViewModel

class UserLoginViewModel : BaseViewModel() {

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