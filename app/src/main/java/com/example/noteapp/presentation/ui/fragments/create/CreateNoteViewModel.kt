package com.example.noteapp.presentation.ui.fragments.create

import com.example.model.Note
import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.NoteUI
import com.example.noteapp.presentation.models.toNote
import com.example.use_cases.note.CreateNoteUseCase
import com.example.use_cases.note.FetchMaxIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val fetchMaxIdUseCase: FetchMaxIdUseCase
) : BaseViewModel() {

    private val _createNoteState = MutableUIStateFlow<Unit>()
    val createNoteState = _createNoteState.asStateFlow()

    fun createNote(note: NoteUI) {
        createNoteUseCase(note.toNote()).collectRequest(_createNoteState) { }
    }

//    private val _noteIdState = MutableUIStateFlow<Unit>()
//    val noteIdState = _noteIdState.asStateFlow()
//
//    fun fetchMaxId() {
//        fetchMaxIdUseCase().collectRequest(_noteIdState){ it.inc() }
//    }

//    private fun makeNote(id: Int, title: String, content: String) = Note(
//        id = id,
//        content = content,
//        title = title,
//    )
}