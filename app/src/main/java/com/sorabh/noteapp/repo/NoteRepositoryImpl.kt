package com.sorabh.noteapp.repo

import com.sorabh.noteapp.data.NoteDao
import com.sorabh.noteapp.model.Note
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao):NoteRepository{
    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }

    override suspend fun getAllNotes() = noteDao.getAllNotes()

}