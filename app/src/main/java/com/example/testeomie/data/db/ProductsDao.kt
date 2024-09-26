package com.example.testeomie.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testeomie.data.db.entities.ProductItem

@Dao
interface ProductsDao {

    @Insert()
    suspend fun upsert(productItem: ProductItem)

    @Query("SELECT * FROM ProdutosComprados")
    fun getAllOrders(): LiveData<List<ProductItem>>

    @Query("SELECT sum(product_total_value) as total FROM ProdutosComprados" )
    fun getTotalListValue():LiveData<Float>

    @Query("SELECT COUNT(*) FROM PRODUTOSCOMPRADOS")
    fun getTotalOrders(): LiveData<Int>


    @Query("DELETE FROM PRODUTOSCOMPRADOS")
    fun dropAllItems()

}