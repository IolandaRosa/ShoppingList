package com.example.shoppinglistapp.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.db.ProductDao
import com.example.shoppinglistapp.model.Product

class ProductRepository(private var productDao: ProductDao) {

    fun getAllProducts(): LiveData<List<Product>> {
        return productDao.getAll()
    }

    fun insertProduct(product: Product) {
        productDao.insert(product)
    }
}