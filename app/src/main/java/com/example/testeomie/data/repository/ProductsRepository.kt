package com.example.testeomie.data.repository

import com.example.testeomie.data.db.ProductsDatabase
import com.example.testeomie.data.db.entities.ProductItem

class ProductsRepository(
    private val db: ProductsDatabase
) {
    suspend fun upsert(item: ProductItem) = db.getProductsDao().upsert(item)
    fun getAllProductsItems() = db.getProductsDao().getAllOrders()
    fun getTotalListValue() = db.getProductsDao().getTotalListValue()
    fun getTotalOrders() = db.getProductsDao().getTotalOrders()
}

