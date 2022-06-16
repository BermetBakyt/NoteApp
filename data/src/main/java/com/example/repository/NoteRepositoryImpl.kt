package com.example.repository

import com.example.db.dao.NoteDao
import com.example.db.entities.NoteEntity
import com.example.db.entities.toNote
import com.example.db.entities.toNoteEntity
import com.example.model.Note
import com.example.repository.base.BaseRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao,
) : BaseRepository(), NoteRepository {

    override fun createNote(note: Note) = doRequest {
         dao.addNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        dao.deleteNote(note.toNoteEntity())
    }

    override fun updateNote(note: Note) = doRequest {
         dao.updateNote(note.toNoteEntity())
    }

    override fun fetchNotes() = doRequest {
        dao.fetchAllNotes().map { it.toNote() }
    }

    override fun getNoteById(id: Int) = doRequest {
        dao.getNoteById(id).toNote()
    }
}