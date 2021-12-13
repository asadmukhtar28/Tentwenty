package com.asad.tentwenty.di.module

import com.asad.tentwenty.BuildConfig
import com.asad.tentwenty.data.remote.AppService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): AppService =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BaseApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(ApiHttpClient().getHTTPClient())
            .build()
            .create(AppService::class.java)


}
