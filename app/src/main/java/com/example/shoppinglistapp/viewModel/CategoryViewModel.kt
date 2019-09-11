package com.example.shoppinglistapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shoppinglistapp.db.ShoppingListDatabase
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.repository.CategoryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    var categoryRepository: CategoryRepository? = null

    init {
        val categoryDao = ShoppingListDatabase.getInstance(application).categoryDao()
        categoryRepository = CategoryRepository(categoryDao)
    }

    fun insert(category: Category) = GlobalScope.launch {
        categoryRepository?.insertCategory(category)
    }
}