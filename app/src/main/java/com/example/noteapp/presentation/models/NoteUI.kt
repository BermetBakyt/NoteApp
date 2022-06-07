package com.example.noteapp.presentation.models

import com.example.model.Note

data class NoteUI(
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int = -1
)

fun Note.toNoteUI() = NoteUI(
    id, title, content, timestamp, color
)