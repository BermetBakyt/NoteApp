package com.example.noteapp.presentation.ui.fragments.list

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentListBinding
import com.example.noteapp.presentation.adapters.NoteAdapter
import com.example.noteapp.presentation.base.BaseFragment

class NotesFragment : BaseFragment<NotesViewModel, FragmentListBinding>(
    R.layout.fragment_list
){
    override val viewModel: NotesViewModel by viewModels()
    override val binding by viewBinding(FragmentListBinding::bind)
    private val notesAdapter: NoteAdapter by lazy {
        NoteAdapter { id ->
            findNavController().navigate(
                NotesFragmentDirections.actionListFragmentToUpdateNoteFragment(id)
            )
        }
    }
}