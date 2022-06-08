package com.example.remote.service

import com.example.remote.dto.NoteDto

interface FirestoreService {

        suspend fun addNote(note: NoteDto)

        suspend fun deleteNote(note: NoteDto)

        suspend fun updateNote(note: NoteDto)

        suspend fun fetchAllNotes() : List<NoteDto>

        suspend fun searchNote(note: NoteDto) : NoteDto
    }
