package com.example.shoppinglistapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shoppinglistapp.db.ShoppingListDatabase
import com.example.shoppinglistapp.model.Product
import com.example.shoppinglistapp.repository.ProductRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    var productRepository: ProductRepository? = null

    init {
        val productDao = ShoppingListDatabase.getInstance(application).productDao()

        productRepository = ProductRepository(productDao)
    }

    fun insert(product: Product) = GlobalScope.launch {
        productRepository?.insertProduct(product)
    }
}