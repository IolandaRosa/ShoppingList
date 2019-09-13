package com.example.shoppinglistapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglistapp.model.Category

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category): Long

    @Query("SELECT * FROM categories")
    fun getAll(): LiveData<MutableList<Category>>

    @Delete
    suspend fun delete(category: Category)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(category: Category)
}