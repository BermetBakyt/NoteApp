package com.example.repository

import com.example.Either
import com.example.db.dao.NoteDao
import com.example.db.database.NoteDatabase
import com.example.db.entities.NoteEntity
import com.example.model.Note
import com.example.repository.base.BaseRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao,
    private val service:
) : BaseRepository(), NoteRepository {

    override fun createNote(note: NoteEntity) = doRequest {
       db.getNoteDao().addNote(note)
    }

    override fun deleteNote() = doRequest {
        suspend fun deleteNote(note: NoteEntity) = db.getNoteDao().deleteNote(note)
    }

    override fun updateNote() = doRequest {
        suspend fun updateNote(note: NoteEntity) = db.getNoteDao().updateNote(note)
    }

    override fun fetchNotes() = doRequest {
        fun getNoteFromDB() =db.getNoteDao().fetchAllNotes()
    }

    override fun searchNotes() = doRequest {
        fun searchNote(query: String) = db.getNoteDao().searchNote(query)
    }

    override fun getNoteById(id: Int) = doRequest {
        fun getNoteById(id: Int) = db.getNoteDao().getNoteById(id)

    }
}