package com.example.moneymanagementapp.data.local.room.dao

import androidx.room.*
import com.example.moneymanagementapp.data.local.room.entity.Transaction
import com.example.moneymanagementapp.data.local.room.entity.relations.CategoriesWithTransaction

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transaction: Transaction) : Long

    @Delete
    suspend fun deleteTransaction(transaction: Transaction) : Int

    @Update
    suspend fun updateTransaction(transaction: Transaction) : Int

    @Query("SELECT * FROM transaction_table ORDER BY id DESC")
    suspend fun getAllTransactions(): List<Transaction>

    @Query("SELECT TOTAL(transactionAmount) FROM transaction_table WHERE transactionType = 'INCOME'")
    suspend fun getTotalIncome(): Double

    @Query("SELECT TOTAL(transactionAmount) FROM transaction_table WHERE transactionType = 'EXPENSE'")
    suspend fun getTotalExpense(): Double

    @Query("SELECT (SELECT TOTAL(transactionAmount) FROM transaction_table WHERE transactionType = 'INCOME') - (SELECT TOTAL(transactionAmount) FROM transaction_table WHERE transactionType = 'EXPENSE')")
    suspend fun getTotalAmount(): Double

    @Query("SELECT * FROM transaction_table WHERE ID == :id")
    suspend fun getTransactionById(id : Int) : List<Transaction>

    @Query("SELECT * FROM categories_table WHERE categoryName = :categoryName")
    suspend fun getCategoryWithTransaction(categoryName: String): List<CategoriesWithTransaction>
}