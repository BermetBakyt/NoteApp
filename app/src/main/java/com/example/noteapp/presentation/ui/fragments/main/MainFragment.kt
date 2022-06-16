package com.example.noteapp.presentation.ui.fragments.main

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentMainBinding
import com.example.noteapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment(
) : BaseFragment<MainViewModel, FragmentMainBinding>(
    R.layout.fragment_main
) {

    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()

    override fun setupListeners() = with(binding) {
        viewModel.authenticationState.observe(viewLifecycleOwner) { authenticationState ->
            when (authenticationState) {
                MainViewModel.AuthenticationState.AUTHENTICATED -> {
                    accountButton.setOnClickListener {
                        findNavController().navigate(MainFragmentDirections.actionMainFragmentToListFragment())
                    }
                }
                else -> {
                    accountButton.setOnClickListener {
                        findNavController().navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
                    }
                }
            }
        }
    }
}