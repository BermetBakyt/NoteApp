package com.example.use_cases.note

import com.example.repository.NoteRepository

class UpdateNoteUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke() = repository.updateNote()
}