package com.example.db

import android.content.Context
import androidx.room.Room
import com.example.db.dao.NoteDao
import com.example.db.database.NoteDatabase

class RoomClient {

    fun provideAppDataBase(context: Context) = Room
        .databaseBuilder(context, NoteDatabase::class.java, "note.db")
        .build()

    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.getNoteDao()

}