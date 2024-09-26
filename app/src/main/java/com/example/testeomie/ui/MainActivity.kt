package com.example.testeomie.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.testeomie.R
import com.example.testeomie.databinding.ActivityMainBinding
import com.example.testeomie.databinding.ActivityProductsListBinding
import com.example.testeomie.ui.viewmodel.ProductsViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComprar.setOnClickListener{
            val intent = Intent(this, ProductsListActivity::class.java).apply {
                putExtra("Customer", binding.etCustomerName.text.toString())
            }
            startActivity(intent)
        }
    }
}