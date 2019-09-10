package com.example.shoppinglistapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "subcategories",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"],
            childColumns = ["subcategoryId"],
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index("subcategoryId")]
)
data class Subcategory(
    @PrimaryKey(autoGenerate = true) var subcategoryId: Long? = null,
    var name: String,
    var color: String
)
