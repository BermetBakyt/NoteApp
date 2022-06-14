package com.example.repository

import com.example.Either
import com.example.db.dao.NoteDao
import com.example.db.entities.NoteEntity
import com.example.db.entities.toNote
import com.example.model.Note
import com.example.repository.base.BaseRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao,
) : BaseRepository(), NoteRepository {

    override fun createNote(note: NoteEntity) = doRequest {
       dao.addNote().map{  it.toNote() }
    }

    override fun deleteNote(note: NoteEntity) = doRequest {
        dao.deleteNote().map { it.toNote() }
    }

    override fun updateNote(note: NoteEntity) = doRequest {
        dao.updateNote().map {it.toNote() }
    }

    override fun fetchNotes() = doRequest {
        dao.fetchAllNotes().map { it.toNote() }
    }

    override fun searchNotes(query: String) = doRequest {
        dao.searchNote(query) {it.toNote() }
    }

    override fun getNoteById(id: Int) = doRequest {
        dao.getNoteById(id)
    }
}