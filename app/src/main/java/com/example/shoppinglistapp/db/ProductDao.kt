package com.example.shoppinglistapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.shoppinglistapp.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAll():LiveData<List<Product>>

    @Insert(onConflict = REPLACE)
    fun insert(product: Product):Long
}