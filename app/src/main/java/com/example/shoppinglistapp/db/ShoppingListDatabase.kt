package com.example.shoppinglistapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.utils.Converters

@Database(entities = arrayOf(Product::class, Category::class), version = 2)
@TypeConverters(Converters::class)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao

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