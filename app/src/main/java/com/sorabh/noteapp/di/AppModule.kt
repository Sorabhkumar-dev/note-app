package com.sorabh.noteapp.di

import android.content.Context
import androidx.room.Room
import com.sorabh.noteapp.data.Constant
import com.sorabh.noteapp.data.NoteDao
import com.sorabh.noteapp.data.NoteDatabase
import com.sorabh.noteapp.repo.NoteRepository
import com.sorabh.noteapp.repo.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun getNoteDb(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java, Constant.NOTE_DB).build()

    @Provides
    fun getNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.getNoteDao()

    @Provides
    fun getNoteRepository(noteRepository: NoteRepositoryImpl): NoteRepository = noteRepository
}