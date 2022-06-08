package com.example.noteapp.presentation.ui.fragments.create

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentCreateNoteBinding
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort

class CreateNoteFragment(
) : BaseFragment<CreateNoteViewModel, FragmentCreateNoteBinding>(
    R.layout.fragment_create_note
) {

    override val binding: FragmentCreateNoteBinding by viewBinding(FragmentCreateNoteBinding::bind)
    override val viewModel: CreateNoteViewModel by viewModels()

    override fun setupListeners() = with(binding) {

        saveNote.setOnClickListener {
            viewModel.createNewNote()
        }

        backBtn.setOnClickListener {
            //to do - go to the previous fragment
        }

        fabColorPicker.setOnClickListener {
            // to do- save the picked color
        }
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.createNoteState.collectUIState(
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                editNoteContent.setText(it.content)
                editTitle.setText(it.title)
                //to do - save the color picked
            }
        )
    }
}