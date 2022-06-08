package com.example.remote.dto

import com.example.model.Note

class NoteDto(
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int = -1
)

fun NoteDto.toNote() = Note (
    id, title, content, timestamp, color
)