package com.example.testeomie

import android.app.Application
import com.example.testeomie.data.db.ProductsDatabase
import com.example.testeomie.data.repository.ProductsRepository
import com.example.testeomie.ui.viewmodel.ProductsViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ProductsApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy{
        import(androidXModule(this@ProductsApplication))
        bind() from singleton { ProductsDatabase(instance()) }
        bind() from singleton { ProductsRepository(instance()) }
        bind() from provider { ProductsViewModelFactory(instance()) }
    }
}