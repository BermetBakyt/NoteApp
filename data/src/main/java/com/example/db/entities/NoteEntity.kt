package com.example.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.Note
import java.io.Serializable

@Entity
class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val content: String
) : Serializable

fun NoteEntity.toNote() = Note(
    id, title, content
)

fun Note.toNoteEntity() = NoteEntity(
    id, title, content
)