package com.example.noteapp.presentation.ui.fragments.login

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentLoginBinding
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort

class UserLoginFragment(
) : BaseFragment<UserLoginViewModel, FragmentLoginBinding>(
    R.layout.fragment_login
){

    override val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    override val viewModel: UserLoginViewModel by viewModels()

    override fun setupListeners() = with(binding) {

        btnLogin.setOnClickListener {

            if (emailField.text.toString().isNotEmpty() && passwordField.text.toString()
                    .isNotEmpty()
            ) {
                viewModel.loginUser()
            }
        }
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.userLoginState.collectUIState(
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                usernameField.setText(it.name)
                emailField.setText(it.email)
                passwordField.setText(it.password)
            }
        )
    }
}