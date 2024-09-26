package com.example.testeomie.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.example.testeomie.data.db.entities.ProductItem
import com.example.testeomie.databinding.AddItemDialogBinding

class AddProductsDialog(context: Context, var addProductListener: AddProductListener) :
    AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = AddItemDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddProduct.setOnClickListener {

            val name = binding.etProductName.text.toString()
            val amount = binding.etProductAmount.text.toString()
            val value = binding.etProductValue.text.toString()
            val desc = binding.etProductDesc.text.toString()

            if (name.isEmpty() || amount.isEmpty() || value.isEmpty()) {
                addProductListener.onAddProductError(true)
                dismiss()

            } else {
                val totalValue = amount.toInt()* value.toFloat()
                val item = ProductItem(name, amount, value, desc, totalValue)
                addProductListener.onAddProductItem(item)
                dismiss()
            }
        }
    }
}