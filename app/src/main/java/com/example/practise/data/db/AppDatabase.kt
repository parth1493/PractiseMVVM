package com.example.practise.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practise.data.db.entites.Quote
import com.example.practise.data.db.entites.User

@Database(
    entities = [User::class,Quote::class],
    version = 1
)
abstract class AppDatabase :RoomDatabase(){

    abstract fun getUserDao():UserDao
    abstract fun getQuoteDao(): QuoteDao

    companion object{

        @Volatile
        private var instance: AppDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Mydatabase.db"
            ).build()
    }
}