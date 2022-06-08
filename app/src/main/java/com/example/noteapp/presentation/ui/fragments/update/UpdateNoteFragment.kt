package com.example.noteapp.presentation.ui.fragments.update

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentLoginBinding
import com.example.noteapp.databinding.FragmentUpdateNoteBinding
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort
import com.example.noteapp.presentation.ui.fragments.login.UserLoginViewModel

class UpdateNoteFragment : BaseFragment<UpdateNoteViewModel, FragmentUpdateNoteBinding>(
    R.layout.fragment_update_note
){

    override val binding: FragmentUpdateNoteBinding by viewBinding(FragmentUpdateNoteBinding::bind)
    override val viewModel: UpdateNoteViewModel by viewModels()

    override fun setupListeners() = with(binding) {

        saveNote.setOnClickListener {
            viewModel.updateNote()
        }

        backBtn.setOnClickListener {
            //to do - go to the previous fragment
        }

        fabColorPicker.setOnClickListener {
            // to do- save the picked color
        }
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.updateNoteState.collectUIState(
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