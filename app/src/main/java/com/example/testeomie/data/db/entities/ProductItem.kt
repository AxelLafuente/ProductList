package com.example.testeomie.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ProdutosComprados")
data class ProductItem(
    @ColumnInfo(name = "product_name")
    var name : String,

    @ColumnInfo(name = "product_amount")
    var amount : String,

    @ColumnInfo(name = "product_value")
    var value: String,


    @ColumnInfo(name = "product_desc")
    var description: String?,

    @ColumnInfo(name = "product_total_value")
    var totalValue: Float,

    @PrimaryKey(autoGenerate = true)
    var orderId: Int? = null
)
