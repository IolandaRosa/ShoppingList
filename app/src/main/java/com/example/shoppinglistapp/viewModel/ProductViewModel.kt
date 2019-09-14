package com.example.shoppinglistapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.db.ShoppingListDatabase
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.repository.ProductRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    var productRepository: ProductRepository? = null

    var productsAll: LiveData<MutableList<Product>>

    init {
        val productDao = ShoppingListDatabase.getInstance(application).productDao()

        productRepository = ProductRepository(productDao)

        productsAll = productRepository?.getAllProducts()!!
    }

    fun insert(product: Product) = GlobalScope.launch {
        productRepository?.insertProduct(product)
    }

    fun update(product: Product) = GlobalScope.launch {
        productRepository?.updateProduct(product)
    }

    fun delete(product: Product) = GlobalScope.launch {
        productRepository?.deleteProduct(product)
    }
}