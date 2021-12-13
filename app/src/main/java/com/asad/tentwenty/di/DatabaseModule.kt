package com.asad.tentwenty.di

import android.content.Context
import androidx.room.Room
import com.asad.tentwenty.data.local.db.AppDatabase
import com.asad.tentwenty.utils.CommonConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, CommonConstants.DB_NAME)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return CommonConstants.DB_NAME
    }

}
