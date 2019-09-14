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
    fun insert(product: Product): Long

    @Update(onConflict = REPLACE)
    fun update(product: Product)

    @Delete
    fun delete(product: Product)
}