package com.example.db.dao

import androidx.room.*
import com.example.db.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Query("SELECT * FROM NoteEntity ORDER BY id DESC")
    fun fetchAllNotes() : List<NoteEntity>

    @Query("SELECT * FROM NoteEntity WHERE title LIKE:query OR content LIKE:query OR date LIKE :query ORDER BY id DESC")
    suspend fun searchNote(query: String) : List<NoteEntity>

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * From NoteEntity")
    suspend fun getNoteById(id: Int): NoteEntity

}