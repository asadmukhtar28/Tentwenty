package com.asad.tentwenty.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asad.tentwenty.data.remote.models.movie.Dates

@Database(entities = [Dates::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun contactsDao(): ContactsDao
}