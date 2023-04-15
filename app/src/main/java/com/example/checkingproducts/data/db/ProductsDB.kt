package com.example.checkingproducts.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.checkingproducts.constants.GlobalConstants
import com.example.checkingproducts.data.db.dao.ProductDao
import com.example.checkingproducts.data.db.entities.ProductEntityDB

@Database(
    entities = [
        ProductEntityDB::class
    ],
    version = GlobalConstants.DB_VERSION,
    exportSchema = false
)

abstract class ProductsDB : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        /* The value of a volatile variable will never be cached and all writes and reads will de done to and from the main memory.
        * This helps to make sure that the value of INSTANCE is always up-to-date and the same for all execution threads.
        * It means that changes made by one thread to INSTANCE are visible to all other threads immediately*/
        @Volatile
        private var INSTANCE: ProductsDB? = null

        fun getInstance(context: Context): ProductsDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductsDB::class.java,
                        GlobalConstants.DB_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}