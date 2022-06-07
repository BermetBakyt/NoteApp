package com.example.use_cases.note

import com.example.repository.NoteRepository

class GetNoteByIdUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke(id: Int) = repository.getNoteById(id)
}