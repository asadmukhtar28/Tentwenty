package com.asad.tentwenty.di.module

import com.asad.tentwenty.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class ApiHttpClient {
    fun getHTTPClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)

        httpClient.addInterceptor { chain ->
            val request = chain.request()
            chain.proceed(/*preferencesHelper.getAccessToken().let {
                request.newBuilder().addHeader(
                    "token",
                    it
                ).build()
            } ?: run {

            }*/
                request
            )
        }

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            httpClient.addInterceptor(logging)
        }
        return httpClient.build()
    }
}
