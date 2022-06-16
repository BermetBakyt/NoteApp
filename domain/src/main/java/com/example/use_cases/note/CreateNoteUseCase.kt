package com.example.use_cases.note

import com.example.model.Note
import com.example.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(note: Note) = repository.createNote(note)
}