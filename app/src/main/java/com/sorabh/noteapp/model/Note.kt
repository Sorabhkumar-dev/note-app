package com.sorabh.noteapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sorabh.noteapp.data.Constant
import com.sorabh.noteapp.utils.DataTimeStampConverter
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = Constant.NOTE_TABLE )
data class Note(
    @PrimaryKey(autoGenerate = false)
    val id:UUID = UUID.randomUUID(),
    val title:String,
    val description:String,
    val entryDate:LocalDateTime = LocalDateTime.now()
)
