package com.example.noteapp.presentation.ui.fragments.create

import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.NoteUI
import com.example.noteapp.presentation.models.toNoteUI
import com.example.use_cases.note.CreateNoteUseCase
import kotlinx.coroutines.flow.asStateFlow

class CreateNoteViewModel(
    private val createNoteUseCase: CreateNoteUseCase
) : BaseViewModel() {

//    private val _createNoteState = MutableUIStateFlow<NoteUI>()
//    val createNoteState = _createNoteState.asStateFlow()
//
//    fun createNewNote() {
//        createNoteUseCase().collectRequest(_createNoteState) {
//            it.map { data ->
//                data.toNoteUI()
//            }
//        }
//    }
}