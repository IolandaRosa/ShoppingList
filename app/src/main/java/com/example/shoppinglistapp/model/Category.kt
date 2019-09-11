package com.example.shoppinglistapp.model

import androidx.room.*

@Entity(tableName = "categories")
class Category(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var name: String="",
    var color: String = ""
)