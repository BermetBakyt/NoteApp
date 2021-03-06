package com.example.noteapp.presentation.ui.fragments.update

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentUpdateNoteBinding
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort
import com.example.noteapp.presentation.models.NoteUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateNoteFragment(
) : BaseFragment<UpdateNoteViewModel, FragmentUpdateNoteBinding>(
    R.layout.fragment_update_note
) {
    override val binding by viewBinding(FragmentUpdateNoteBinding::bind)
    override val viewModel: UpdateNoteViewModel by viewModels()
    private val args: UpdateNoteFragmentArgs by navArgs()

    override fun setupRequests() {
        viewModel.fetchNoteDetail(args.id)
    }

    override fun setupListeners() = with(binding) {

        saveNote.setOnClickListener {
            viewModel.updateNote(
                NoteUI(
                    args.id,
                    editNoteContent.text.toString(),
                    editTitle.text.toString(),
                )
            )
        }

        deleteNote.setOnClickListener {
            viewModel.deleteNote(
                NoteUI(
                    args.id,
                    editNoteContent.text.toString(),
                    editTitle.text.toString(),
                )
            )
        }

        backBtn.setOnClickListener {
            findNavController().navigate(
                UpdateNoteFragmentDirections.actionUpdateNoteFragmentToListFragment()
            )
        }
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.fetchNoteState.collectUIState(
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                editTitle.setText(it.title)
                editNoteContent.setText(it.content)
            }
        )

        viewModel.updateNoteState.collectUIState(
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                showToastShort("Note saved")
            }
        )

        viewModel.deleteNoteState.collectUIState(
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                showToastShort("Note deleted")
            }
        )
    }
}