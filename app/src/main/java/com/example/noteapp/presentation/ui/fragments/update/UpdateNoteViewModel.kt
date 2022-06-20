package com.example.noteapp.presentation.ui.fragments.update

import com.example.model.Note
import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.NoteUI
import com.example.noteapp.presentation.models.toNote
import com.example.noteapp.presentation.models.toNoteUI
import com.example.use_cases.note.DeleteNoteUseCase
import com.example.use_cases.note.GetNoteByIdUseCase
import com.example.use_cases.note.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UpdateNoteViewModel @Inject constructor(
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
) : BaseViewModel(){

    private val _updateNoteState = MutableUIStateFlow<Unit>()
    val updateNoteState = _updateNoteState.asStateFlow()

    private val _fetchNoteState = MutableUIStateFlow<NoteUI>()
    val fetchNoteState = _fetchNoteState.asStateFlow()

    private val _deleteNoteState = MutableUIStateFlow<Unit>()
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun updateNote(existingNote: NoteUI) {
        updateNoteUseCase(existingNote.toNote()).collectRequest(_updateNoteState) {}
    }

    fun deleteNote(existingNote: NoteUI) {
        deleteNoteUseCase(existingNote.toNote()).collectRequest(_deleteNoteState) {}
    }

    fun fetchNoteDetail(id: Int) {
        getNoteByIdUseCase(id).collectRequest(_fetchNoteState) { it.toNoteUI()}
    }
}