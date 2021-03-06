package com.example.noteapp.presentation.ui.fragments.list

import androidx.lifecycle.map
import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.NoteUI
import com.example.noteapp.presentation.models.toNoteUI
import com.example.noteapp.presentation.ui.fragments.login.FirebaseUserLiveData
import com.example.use_cases.note.FetchNotesUseCase
import com.example.use_cases.note.GetNoteByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val fetchNotesUseCase: FetchNotesUseCase
) : BaseViewModel() {

    private val _noteListState = MutableUIStateFlow<List<NoteUI>>()
    val noteListState = _noteListState.asStateFlow()

    fun fetchNotes() {
        fetchNotesUseCase().collectRequest(_noteListState) { it ->
            it.map { it.toNoteUI() } }
    }

}