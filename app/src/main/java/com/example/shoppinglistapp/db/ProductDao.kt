package com.example.shoppinglistapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.shoppinglistapp.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAll(): LiveData<MutableList<Product>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(product: Product): Long

    @Update(onConflict = REPLACE)
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM products WHERE myList=1")
    fun getMyList():LiveData<MutableList<Product>>
}