package com.example.shoppinglistapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
class Category(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var name: String = "",
    var color: String = ""
)