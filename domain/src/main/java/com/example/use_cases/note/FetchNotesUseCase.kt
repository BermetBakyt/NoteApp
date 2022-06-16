package com.example.use_cases.note

import com.example.repository.NoteRepository
import javax.inject.Inject

class FetchNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke() = repository.fetchNotes()
}