package com.example.merchant.util.di

import android.content.Context
import com.example.merchant.BuildConfig
import com.example.merchant.networkapiservice.CommonApiService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val DEBUG_BASE_URL = "https://desolate-tundra-11009.herokuapp.com/"

@Module
object NetworkModule {
    @Provides
    @Singleton
    @JvmStatic
    fun okHttpClient(context: Context): OkHttpClient {


        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(getHttpLoggingInterceptor())
            .build()

        return okHttpClient

    }

    @Provides
    @Singleton
    @JvmStatic
    fun retrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    }

    private fun getBaseUrl(): String {
        return if (BuildConfig.DEBUG) {
            DEBUG_BASE_URL
        } else {
            DEBUG_BASE_URL
        }
    }


    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideGson(): Gson {
        return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setPrettyPrinting()
            .setLenient()
            .serializeNulls()
            .create()
    }

    @Provides
    @JvmStatic
    fun provideCommonApiService(retrofit: Retrofit):CommonApiService {
        return retrofit.create(CommonApiService::class.java)
    }
}