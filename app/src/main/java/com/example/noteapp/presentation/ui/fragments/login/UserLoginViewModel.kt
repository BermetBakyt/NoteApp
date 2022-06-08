package com.example.noteapp.presentation.ui.fragments.login

import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.UserUI
import com.example.noteapp.presentation.models.toUserUI
import com.example.use_cases.user.UserLoginUseCase
import kotlinx.coroutines.flow.asStateFlow

class UserLoginViewModel(
    private val loginUseCase: UserLoginUseCase
) : BaseViewModel() {

    private val _userLoginState = MutableUIStateFlow<UserUI>()
    val userLoginState = _userLoginState.asStateFlow()

    fun loginUser() {
        loginUseCase().collectRequest(_userLoginState) { it.toUserUI() }
    }
}