package com.example.db.dao

import androidx.room.*
import com.example.db.entities.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: NoteEntity) : NoteEntity

    @Update
    suspend fun updateNote() : NoteEntity

    @Query("SELECT * FROM NoteEntity ORDER BY id DESC")
    suspend fun fetchAllNotes() : List<NoteEntity>

    @Query("SELECT * FROM NoteEntity WHERE title LIKE:query OR content LIKE:query")
    suspend fun searchNote(query: String) : List<NoteEntity>

    @Delete
    suspend fun deleteNote() : NoteEntity

    @Query("SELECT * FROM NoteEntity WHERE id= :id")
    suspend fun getNoteById(id: Int) : NoteEntity
}