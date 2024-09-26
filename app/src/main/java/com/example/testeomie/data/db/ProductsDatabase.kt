package com.example.testeomie.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testeomie.data.db.entities.ProductItem

@Database(
    entities = [ProductItem::class],
    version = 1
)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun getProductsDao(): ProductsDao

    companion object {
        @Volatile
        private var instance: ProductsDatabase? = null
        private val LOCK = Any()


        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it}
        }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ProductsDatabase::class.java, "ProductsDB.db"
            ).build()
    }
}