package com.example.testeomie.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testeomie.data.db.entities.ProductItem
import com.example.testeomie.data.repository.ProductsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val repository: ProductsRepository
) : ViewModel() {
    fun upsert(item: ProductItem) = GlobalScope.launch {
        repository.upsert(item)
    }

    fun getAllProductsItems() = repository.getAllProductsItems()

    fun getTotalValueItems() = repository.getTotalListValue()
    fun getTotalOrders() = repository.getTotalOrders()


}