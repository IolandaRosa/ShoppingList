package com.example.shoppinglistapp.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglistapp.db.CategoryDao
import com.example.shoppinglistapp.model.Category

class CategoryRepository(private var categoryDao: CategoryDao) {

    suspend fun insertCategory(category: Category) {
        categoryDao.insert(category)
    }

    fun getAllCategories(): LiveData<MutableList<Category>> {
        return categoryDao.getAll()
    }

    suspend fun deleteCategory(category: Category) {
        categoryDao.delete(category)
    }

    suspend fun updateCategory(category: Category) {
        categoryDao.update(category)
    }
}