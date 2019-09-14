package com.example.shoppinglistapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("categoryId")]
)

data class Product(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    var name: String = "",
    var brand: String = "",
    var quantity: Int = 0,
    var category: Category? = null,
    var myList: Boolean = false,
    var categoryId: Long? = null
)
