package com.example.noteapp.presentation.ui.fragments.register

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentRegisterBinding
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort
import com.google.firebase.auth.FirebaseAuth

class UserRegisterFragment(
) : BaseFragment<UserRegisterViewModel, FragmentRegisterBinding>(
    R.layout.fragment_register
) {

    override val binding by viewBinding(FragmentRegisterBinding::bind)
    override val viewModel: UserRegisterViewModel by viewModels()

    override fun setupListeners() = with(binding) {

        btnRegister.setOnClickListener {

            if (emailField.text.toString().isNotEmpty() && passwordField.text.toString()
                    .isNotEmpty()
            ) {
                viewModel.registerUser()
            }
        }
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.userRegisterState.collectUIState(
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