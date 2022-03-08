package com.example.moneymanagementapp.data.local.room.dao

import androidx.room.*
import com.example.moneymanagementapp.data.local.room.entity.Categories

@Dao
interface CategoriesDao {
    @Insert
    suspend fun insertCategory(category: Categories): Long

    @Update
    suspend fun updateCategory(category: Categories): Int

    @Delete
    suspend fun deleteCategory(category: Categories): Int

    @Query("SELECT * from categories_table WHERE categoryType = '0'")
    fun getIncomeCategories(): List<Categories>

    @Query("SELECT * from categories_table WHERE categoryType = '1'")
    fun getExpenseCategories(): List<Categories>

   /* @Query("SELECT * FROM categories_table WHERE ID == id")
    suspend fun getCategoriesById(id: Int): List<Categories>*/
}