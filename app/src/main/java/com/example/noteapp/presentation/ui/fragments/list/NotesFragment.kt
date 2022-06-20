package com.example.noteapp.presentation.ui.fragments.list

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentListBinding
import com.example.noteapp.presentation.adapters.NoteAdapter
import com.example.noteapp.presentation.base.BaseFragment
import com.example.noteapp.presentation.extensions.showToastShort
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : BaseFragment<NotesViewModel, FragmentListBinding>(
    R.layout.fragment_list
) {
    override val viewModel: NotesViewModel by viewModels()
    override val binding by viewBinding(FragmentListBinding::bind)
    private lateinit var googleSignInClient: GoogleSignInClient

    private val notesAdapter = NoteAdapter(
        this::action
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.webclient_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
    }

    override fun setupRequests() {
        viewModel.fetchNotes()
    }
    override fun initialize() {
        setupListAdapter()
        setupOptionsMenu()
    }

    private fun action(id:Int) {
        Log.e("fragment", "invoked")

        findNavController().navigate(
            NotesFragmentDirections.actionListFragmentToUpdateNoteFragment(id)
        )
    }

    private fun setupListAdapter() = with(binding) {
        with(recyclerViewNotes) {
            adapter = notesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun setupListeners() = with(binding) {
        super.setupListeners()

        fabText.setOnClickListener {
            findNavController().navigate(NotesFragmentDirections.actionListFragmentToCreateNoteFragment())
        }
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

    private fun setupOptionsMenu(): View? {
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.sign_out_item -> {
                AuthUI.getInstance().signOut(requireContext())
                findNavController().navigate(NotesFragmentDirections.actionListFragmentToLoginFragment())
            }
        }
        return true
    }
}

