package com.example.noteapp.presentation.ui.fragments.list

import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.NoteUI
import com.example.noteapp.presentation.models.toNoteUI
import com.example.use_cases.note.FetchNotesUseCase
import kotlinx.coroutines.flow.asStateFlow

class NotesViewModel(
    private val fetchNotesUseCase: FetchNotesUseCase
) : BaseViewModel() {

    private val _noteListState = MutableUIStateFlow<List<NoteUI>>()
    val noteListState = _noteListState.asStateFlow()

    fun fetchNotes() {
        fetchNotesUseCase().collectRequest(_noteListState) { data ->
            data.map {
                it.toNoteUI()
            }
        }
    }
}