package com.example.shoppinglistapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.db.ShoppingListDatabase
import com.example.shoppinglistapp.model.Category
import com.example.shoppinglistapp.repository.CategoryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    var categoryRepository: CategoryRepository? = null

    var categoriesAll: LiveData<MutableList<Category>>

    init {
        val categoryDao = ShoppingListDatabase.getInstance(application).categoryDao()
        categoryRepository = CategoryRepository(categoryDao)

        categoriesAll = categoryRepository?.getAllCategories()!!
    }

    fun insert(category: Category) = GlobalScope.launch {
        categoryRepository?.insertCategory(category)
    }

    fun delete(category: Category) = GlobalScope.launch {
        categoryRepository?.deleteCategory(category)
    }

    fun update(category: Category) = GlobalScope.launch {
        categoryRepository?.updateCategory(category)
    }

}