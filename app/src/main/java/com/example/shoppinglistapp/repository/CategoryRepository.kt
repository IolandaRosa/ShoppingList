package com.example.shoppinglistapp.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.db.CategoryDao
import com.example.shoppinglistapp.model.Category

class CategoryRepository(private var categoryDao: CategoryDao) {

    fun insertCategory(category: Category) {
        categoryDao.insert(category)
    }

    fun getAllCategories(): LiveData<MutableList<Category>> {
        return categoryDao.getAll()
    }
}