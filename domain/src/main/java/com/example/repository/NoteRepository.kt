package com.example.repository

import com.example.Either
import com.example.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Either<String, Unit>>

    fun deleteNote(note: Note): Flow<Either<String, Unit>>

    fun updateNote(note: Note): Flow<Either<String, Unit>>

    fun fetchNotes(): Flow<Either<String, List<Note>>>

    fun getNoteById(id: Int): Flow<Either<String, Note>>

    fun fetchMaxId() : Flow<Either<String, Int>>
}