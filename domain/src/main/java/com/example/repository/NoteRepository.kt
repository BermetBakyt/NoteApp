package com.example.repository

import com.example.Either
import com.example.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note) : Flow<Either<String, Note>>

    fun deleteNote() :  Flow<Either<String, Note>>

    fun updateNote() : Flow<Either<String, Note>>

    fun fetchNotes() : Flow<Either<String, List<Note>>>

    fun searchNotes() : Flow<Either<String, Note>>

    fun getNoteById(id: Int) : Note
}