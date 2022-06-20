package com.example.db.dao

import androidx.room.*
import com.example.db.entities.NoteEntity
import com.example.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(noteEntity: NoteEntity)

    @Update
    suspend fun updateNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM NoteEntity ORDER BY id DESC")
    fun fetchAllNotes() : List<NoteEntity>

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM NoteEntity WHERE id= :id")
    suspend fun getNoteById(id: Int) : NoteEntity

    @Query("SELECT MAX(id) FROM NoteEntity")
    suspend fun getMaxId() : Int

}