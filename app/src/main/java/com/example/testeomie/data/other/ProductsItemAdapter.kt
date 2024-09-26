package com.example.testeomie.data.other

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testeomie.data.db.entities.ProductItem
import com.example.testeomie.databinding.ProductItemBinding
import com.example.testeomie.ui.viewmodel.ProductsViewModel
import com.google.android.material.snackbar.Snackbar


class ProductsItemAdapter(var items: List<ProductItem>, private val viewModel: ProductsViewModel) :
    RecyclerView.Adapter<ProductsItemAdapter.ProductsViewHolder>() {
    inner class ProductsViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        if (position % 2 == 0) {
            holder.binding.root.setBackgroundColor(Color.GRAY)
        }
        val currProductItem = items[position]
        var message = currProductItem.description.toString()

        holder.binding.txtName.text = currProductItem.name
        holder.binding.txtAmount.text = currProductItem.amount
        holder.binding.txtValue.text = currProductItem.value
        holder.binding.txtTotalValue.text = currProductItem.totalValue.toString()
        holder.binding.btnProductDesc.setOnClickListener {
            if (message.isBlank()) {
                "Item sem Descrição".also { message = it }
            }
            Snackbar.make(
                holder.binding.root,
                message,
                Snackbar.LENGTH_LONG
            ).show()

        }
    }
}