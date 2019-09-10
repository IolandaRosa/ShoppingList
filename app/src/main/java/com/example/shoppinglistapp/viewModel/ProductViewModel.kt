package com.example.shoppinglistapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.db.ShoppingListDatabase
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.repository.ProductRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductViewModel(application: Application):AndroidViewModel(application) {

    var productRepository: ProductRepository?=null

    init{
        val productDao = ShoppingListDatabase.getInstance(application).productDao()

        productRepository= ProductRepository(productDao)
    }

    fun getAll(): LiveData<List<Product>> = productRepository?.getAllProducts()!!

    fun insert(product:Product) = GlobalScope.launch {
        productRepository?.insertProduct(product)
    }
}