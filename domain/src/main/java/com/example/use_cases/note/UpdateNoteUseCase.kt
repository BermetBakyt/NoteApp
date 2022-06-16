package com.example.use_cases.note

import com.example.model.Note
import com.example.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(note: Note) = repository.updateNote(note)
}