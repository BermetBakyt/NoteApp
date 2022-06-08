package com.example.noteapp.presentation.ui.fragments.register

import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.UserUI
import com.example.noteapp.presentation.models.toUserUI
import com.example.use_cases.user.RegisterUserViaGoogleUseCase
import kotlinx.coroutines.flow.asStateFlow

class UserRegisterViewModel(
    private val registerUserViaGoogleUseCase: RegisterUserViaGoogleUseCase
) : BaseViewModel() {

    private val _userRegisterState = MutableUIStateFlow<UserUI>()
    val userRegisterState = _userRegisterState.asStateFlow()

    fun registerUser() {
        registerUserViaGoogleUseCase().collectRequest(_userRegisterState) { it.toUserUI() }
    }

}