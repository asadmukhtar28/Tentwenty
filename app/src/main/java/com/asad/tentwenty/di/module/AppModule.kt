package com.asad.tentwenty.di.module

import android.app.Application
import android.content.Context
import com.asad.tentwenty.data.local.db.DbHelper
import com.asad.tentwenty.data.local.db.DbHelperImpl
import com.asad.tentwenty.managers.DataManager
import com.asad.tentwenty.managers.DataManagerImpl
import com.asad.tentwenty.utils.ResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
    @Provides
    fun provideResourceProvider(context: Context): ResourceProvider {
        return ResourceProvider(context.applicationContext)
    }

    @Singleton
    @Provides
    fun provideDataManager(dataManagerImpl: DataManagerImpl): DataManager {
        return dataManagerImpl
    }

    @Singleton
    @Provides
    fun provideDbHelper(dbHelperImpl: DbHelperImpl): DbHelper {
        return dbHelperImpl
    }
}