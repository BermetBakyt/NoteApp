package com.example.noteapp.presentation.ui.fragments.update

import com.example.noteapp.presentation.base.BaseViewModel
import com.example.noteapp.presentation.models.NoteUI
import com.example.noteapp.presentation.models.toNoteUI
import com.example.use_cases.note.UpdateNoteUseCase
import kotlinx.coroutines.flow.asStateFlow

class UpdateNoteViewModel(
    private val updateNoteUseCase: UpdateNoteUseCase
) : BaseViewModel(){

    private val _updateNoteState = MutableUIStateFlow<NoteUI>()
    val updateNoteState = _updateNoteState.asStateFlow()

    fun updateNote() {
        updateNoteUseCase().collectRequest(_updateNoteState) { it.toNoteUI() }
    }
}