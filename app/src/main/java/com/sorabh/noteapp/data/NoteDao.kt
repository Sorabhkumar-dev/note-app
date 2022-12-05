package com.sorabh.noteapp.data

import androidx.room.*
import com.sorabh.noteapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("Delete from note_table")
    suspend fun deleteAllNotes()

    @Query("Select * From note_table ORDER BY  id Desc")
    fun getAllNotes():Flow<List<Note>>

}