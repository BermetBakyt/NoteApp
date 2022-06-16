package com.example.noteapp.presentation.ui.fragments.create

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentCreateNoteBinding
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment(
) : BaseFragment<CreateNoteViewModel, FragmentCreateNoteBinding>(
    R.layout.fragment_create_note
) {

    override val binding: FragmentCreateNoteBinding by viewBinding(FragmentCreateNoteBinding::bind)
    override val viewModel: CreateNoteViewModel by viewModels()

    override fun setupListeners() = with(binding) {

        saveNote.setOnClickListener {
            viewModel.createNote(
                title = editTitle.text.toString(),
                content = editNoteContent.text.toString(),
                id = 1,
            )
        }

        backBtn.setOnClickListener {
            findNavController().navigate(
                CreateNoteFragmentDirections.actionCreateNoteFragmentToListFragment()
            )
        }
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.createNoteState.collectUIState(
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                showToastShort("Note saved")
            }
        )
    }
}