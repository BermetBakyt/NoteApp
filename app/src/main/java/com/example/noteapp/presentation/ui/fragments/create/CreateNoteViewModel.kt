package com.example.noteapp.presentation.ui.fragments.create

import com.example.model.Note
import com.example.noteapp.presentation.base.BaseViewModel
import com.example.use_cases.note.CreateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase
) : BaseViewModel() {

    private val _createNoteState = MutableUIStateFlow<Unit>()
    val createNoteState = _createNoteState.asStateFlow()

    fun createNote(title: String, content: String, id: Int) {
        createNoteUseCase(makeNote(id, content, title)).setData(_createNoteState)
    }

    private fun makeNote(id: Int, title: String, content: String) = Note(
        id = id,
        content = content,
        title = title,
    )
}