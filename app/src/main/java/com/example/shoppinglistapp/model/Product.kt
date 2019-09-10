package com.example.shoppinglistapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) var id:Long?=null,
    var name: String,
    @Ignore var category: Category,
    @Ignore var subcategories:MutableList<Subcategory> ?,
    var brand: String="",
    var quantity: Int = 0,
    @ColumnInfo(name="is_in_myList") var myList: Boolean = false
)
