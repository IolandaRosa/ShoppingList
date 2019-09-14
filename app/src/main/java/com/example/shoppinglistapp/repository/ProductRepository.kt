package com.example.shoppinglistapp.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.db.ProductDao
import com.example.shoppinglistapp.model.Product

class ProductRepository(private var productDao: ProductDao) {

    fun getAllProducts(): LiveData<MutableList<Product>> {
        return productDao.getAll()
    }

    suspend fun insertProduct(product: Product) {
        productDao.insert(product)
    }

    suspend fun updateProduct(product: Product) {
        productDao.update(product)
    }

    suspend fun deleteProduct(product: Product) {
        productDao.delete(product)
    }
}