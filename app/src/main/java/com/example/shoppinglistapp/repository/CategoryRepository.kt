package com.example.shoppinglistapp.repository

import com.example.shoppinglistapp.db.CategoryDao
import com.example.shoppinglistapp.model.Category

class CategoryRepository(private var categoryDao: CategoryDao) {

    fun insertCategory(category: Category) {
        categoryDao.insert(category)
    }
}