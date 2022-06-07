package com.example.use_cases.note

import com.example.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    operator fun invoke() = repository.deleteNote()
}