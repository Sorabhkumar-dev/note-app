package com.sorabh.noteapp.utils

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.*

class DataTimeStampConverter {
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(value) }
    }

    @TypeConverter
    fun dateToTimestamp(localDateTime: LocalDateTime?): String? {
        return localDateTime.toString()
    }
}