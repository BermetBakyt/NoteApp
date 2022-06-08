package com.example.noteapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.NoteItemBinding
import com.example.noteapp.presentation.base.BaseDiffUtilCallback
import com.example.noteapp.presentation.models.NoteUI

class NoteAdapter(
    val onNoteClicked: (id: Int) -> Unit,
) : ListAdapter<NoteUI, NoteAdapter.NoteViewHolder>(BaseDiffUtilCallback()){

    inner class NoteViewHolder(
        private val binding: NoteItemBinding
    ):RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {

                root.setOnClickListener{
                    with(getItem(absoluteAdapterPosition!!)) {
                        onNoteClicked(id)
                    }
                }
            }
        }

        fun bind(note: NoteUI) {
            binding.apply {
                noteContentItem.text = note.content
                noteItemTitle.text = note.title
                noteDate.text = note.timestamp
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}