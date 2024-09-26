package com.example.testeomie.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testeomie.data.db.ProductsDatabase
import com.example.testeomie.data.db.entities.ProductItem
import com.example.testeomie.data.other.ProductsItemAdapter
import com.example.testeomie.data.repository.ProductsRepository
import com.example.testeomie.databinding.ActivityProductsListBinding
import com.example.testeomie.ui.viewmodel.ProductsViewModel
import com.example.testeomie.ui.viewmodel.ProductsViewModelFactory
import com.google.android.material.snackbar.Snackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ProductsListActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: ProductsViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductsListBinding.inflate(layoutInflater)
        val customerName = intent.getStringExtra("Customer")
        setContentView(binding.root)

        val viewmodel = ViewModelProvider(this, factory).get(ProductsViewModel::class)
        val adapter = ProductsItemAdapter(listOf(), viewmodel)
        binding.txtCustomerName.text = "Cliente:$customerName"
        binding.rvProductsList.layoutManager = LinearLayoutManager(this)
        binding.rvProductsList.adapter = adapter

        viewmodel.getTotalValueItems().observe(this, Observer {
            binding.txtTotalListValue.text = "R$$it"
        })
        viewmodel.getAllProductsItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        viewmodel.getTotalOrders().observe(this, Observer {
            binding.txtOrderNumber.text = "Pedido Nº:$it"
        })



        binding.btnAddItens.setOnClickListener {
            AddProductsDialog(context = this,
                object : AddProductListener {
                    override fun onAddProductItem(item: ProductItem) {
                        viewmodel.upsert(item)
                    }

                    override fun onAddProductError(flag: Boolean) {
                        if (flag) {
                            Snackbar.make(
                                binding.root,
                                "Produto invalido, verifique se os campos foram preenchidos",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                    }
                }).show()
        }
    }
}