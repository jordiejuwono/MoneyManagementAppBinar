package com.example.moneymanagementapp.data.local.room.datasource.category

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.moneymanagementapp.data.local.room.entity.Categories

interface CategoriesDataSource {

    suspend fun insertCategory(category: Categories): Long

    suspend fun updateCategory(category: Categories): Int

    suspend fun deleteCategory(category: Categories): Int

    suspend fun getIncomeCategories(): List<Categories>

    suspend fun getExpenseCategories(): List<Categories>

    suspend fun getIncomeTitle(): List<String>

    suspend fun getExpenseTitle(): List<String>

    /*suspend fun getCategoriesById(id: Int): List<Categories>*/
}