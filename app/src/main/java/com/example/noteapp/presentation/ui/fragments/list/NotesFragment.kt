package com.example.noteapp.presentation.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentListBinding
import com.example.noteapp.presentation.adapters.NoteAdapter
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : BaseFragment<NotesViewModel, FragmentListBinding>(
    R.layout.fragment_list
) {
    override val viewModel: NotesViewModel by viewModels()
    override val binding by viewBinding(FragmentListBinding::bind)
    private val notesAdapter = NoteAdapter(
        this::onNoteClicked
    )

    private fun onNoteClicked(id: Int) {
        findNavController().navigate(
            NotesFragmentDirections.actionListFragmentToUpdateNoteFragment(
                id = id
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun setupRequests() {
        viewModel.fetchNotes()
    }
    override fun initialize() {
        setupListAdapter()
    }

    override fun setupListeners() = with(binding) {
        super.setupListeners()

        fabText.setOnClickListener {
            findNavController().navigate(NotesFragmentDirections.actionListFragmentToCreateNoteFragment())
        }
    }

    private fun setupListAdapter() = with(binding.recyclerViewNotes) {
        this.adapter = notesAdapter
        layoutManager = LinearLayoutManager(context)
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.noteListState.collectUIState(
            onError = {
                showToastShort(it)
            },
            onSuccess = {
                notesAdapter.submitList(it)
            }
        )
    }
}

