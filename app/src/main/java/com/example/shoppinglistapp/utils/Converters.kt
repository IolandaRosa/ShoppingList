package com.example.shoppinglistapp.utils

import androidx.room.TypeConverter
import com.example.shoppinglistapp.model.Category

class Converters {

    @TypeConverter
    fun fromString(value: String?): Category? {

        if (value == null)
            return null

        val strSplit = value.split(",")

        return Category(strSplit[0].toLong(), strSplit[1], strSplit[2])
    }

    @TypeConverter
    fun toString(value: Category?): String? {
        if (value == null)
            return null

        return "${value.id},${value.name},${value.color}"
    }
}