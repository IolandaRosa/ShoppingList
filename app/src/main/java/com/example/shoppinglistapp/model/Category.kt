package com.example.shoppinglistapp.model

import androidx.room.*

@Entity(
    tableName = "categories",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("categoryId")]
)
data class Category(
    @PrimaryKey(autoGenerate = true) var categoryId: Long? = null,
    var name: String,
    @Ignore var subcategories: List<Subcategory> = emptyList(),
    var color: String = ""
)