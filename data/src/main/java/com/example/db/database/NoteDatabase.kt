package com.example.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.dao.NoteDao
import com.example.db.entities.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}