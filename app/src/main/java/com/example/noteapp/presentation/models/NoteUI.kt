package com.example.noteapp.presentation.models

import com.example.model.Note
import com.example.noteapp.presentation.base.IBaseDiffModel

data class NoteUI(
   override val id: Int,
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int = -1
): IBaseDiffModel

fun Note.toNoteUI() = NoteUI(
    id, title, content, timestamp, color
)