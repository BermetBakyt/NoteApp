package com.example.noteapp.presentation.ui.fragments.update

import com.example.model.Note
import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.NoteUI
import com.example.noteapp.presentation.models.toNoteUI
import com.example.use_cases.note.GetNoteByIdUseCase
import com.example.use_cases.note.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UpdateNoteViewModel @Inject constructor(
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase
) : BaseViewModel(){

    private val _updateNoteState = MutableUIStateFlow<Unit>()
    val updateNoteState = _updateNoteState.asStateFlow()

    private val _fetchNoteState = MutableUIStateFlow<NoteUI>()
    val fetchNoteState = _fetchNoteState.asStateFlow()

    fun updateNote(title: String, content: String, id: Int) {
        updateNoteUseCase(updateNote(id, content, title)).collectRequest(_updateNoteState){ it }
    }

    private fun updateNote(id: Int, title: String, content: String) = Note(
        id = id,
        content = content,
        title = title
    )

    fun fetchNoteDetail(id: Int) {
        getNoteByIdUseCase(id).collectRequest(_fetchNoteState) { it.toNoteUI()}
    }

}