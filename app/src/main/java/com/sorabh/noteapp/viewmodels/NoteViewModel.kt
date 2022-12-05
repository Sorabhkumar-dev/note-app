package com.sorabh.noteapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.noteapp.model.Note
import com.sorabh.noteapp.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
//    private val notes = mutableStateListOf<Note>()

    //    private var _notes :MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    lateinit var notes: Flow<List<Note>>

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            notes = noteRepository.getAllNotes()
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

    fun removeNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

}