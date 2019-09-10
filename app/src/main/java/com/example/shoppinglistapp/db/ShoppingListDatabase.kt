package com.example.shoppinglistapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.model.Subcategory

@Database(entities = arrayOf(Product::class, Category::class, Subcategory::class), version = 1)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun productDao():ProductDao

    companion object {
        private var instance: ShoppingListDatabase? = null

        fun getInstance(context: Context): ShoppingListDatabase {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingListDatabase::class.java, "ShoppingList"
                ).build()
            }
            return instance as ShoppingListDatabase
        }
    }
}