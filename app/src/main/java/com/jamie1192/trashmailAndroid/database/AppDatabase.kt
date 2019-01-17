package com.jamie1192.trashmailAndroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jamie1192.trashmailAndroid.database.dao.DomainDao
import com.jamie1192.trashmailAndroid.database.entities.DomainEntity

/**
 * Created by jamie1192 on 27/11/18.
 */
@Database(entities = [DisposableEntity::class, DomainEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDisposableDao(): DisposableDao
    abstract fun getDomainDao(): DomainDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "userDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}