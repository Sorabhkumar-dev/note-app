package com.sorabh.noteapp.utils

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {
    @TypeConverter
    fun longFromUUID(uuid: UUID): String? = uuid.toString()

    @TypeConverter
    fun uuidFromLong(string: String?): UUID? = UUID.fromString(string)
}