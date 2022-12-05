package com.sorabh.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sorabh.noteapp.model.Note
import com.sorabh.noteapp.utils.DataTimeStampConverter
import com.sorabh.noteapp.utils.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DataTimeStampConverter::class,UUIDConverter::class)
abstract class NoteDatabase :RoomDatabase(){
        abstract fun getNoteDao():NoteDao
}