package com.example.repository

import androidx.room.Query
import com.example.Either
import com.example.db.dao.NoteDao
import com.example.db.database.NoteDatabase
import com.example.db.entities.NoteEntity
import com.example.model.Note
import com.example.remote.service.FirestoreService
import com.example.repository.base.BaseRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao,
    private val service: FirestoreService
) : BaseRepository(), NoteRepository {

    override fun createNote(note: NoteEntity) = doRequest {
       dao.addNote(note)
    }

    override fun deleteNote(note: NoteEntity) = doRequest {
        dao.deleteNote(note)
    }

    override fun updateNote(note: NoteEntity) = doRequest {
        dao.updateNote(note)
    }

    override fun fetchNotes() = doRequest {
        dao.fetchAllNotes()
    }

    override fun searchNotes(query: String) = doRequest {
        dao.searchNote(query)
    }

    override fun getNoteById(id: Int) = doRequest {
        dao.getNoteById(id)

    }
}