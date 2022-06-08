package com.example.model

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int = -1
)