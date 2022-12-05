package com.sorabh.noteapp.data

import com.sorabh.noteapp.model.Note

class NoteDataSource {
    fun getNotes() = listOf(
        Note(title = "Faster IT", description = "Faster IT is indian it tech giant that operate on all around the world"),
        Note(title = "Faster Analytics", description = "Faster Analytics is indian analytics giant that operate on all around the world"),
        Note(title = "Faster AI/ML", description = "Faster AI/ML is indian artificial and machine learning giant that operate on all around the world"),
        Note(title = "Faster Gaming", description = "Faster Gaming is indian it gaming giant that operate on all around the world"),
        Note(title = "Faster Fintech", description = "Faster IT is indian faster financial technology company giant that operate on all around the world and provide financial services using advance technology"),
        Note(title = "Faster CleanTech", description = "Faster IT is indian clean tech giant that operate on all around the world to save enviroment for sustainable future"),
    )
}