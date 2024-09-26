package com.example.testeomie.ui

import com.example.testeomie.data.db.entities.ProductItem

interface AddProductListener {
    fun onAddProductItem(item: ProductItem)

    fun onAddProductError(flag: Boolean)
}
