package com.example.use_cases.note

import com.example.repository.NoteRepository

class CreateNoteUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke() = repository.createNote()
}