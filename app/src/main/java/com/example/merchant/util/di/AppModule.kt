package com.example.merchant.util.di

import android.content.Context
import androidx.room.Room
import com.example.merchant.dao.ItemDao
import com.example.merchant.util.AppDatabase
import com.example.merchant.util.DATABASE_NAME
import com.example.merchant.util.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object AppModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideContext(app: MyApplication): Context = app.applicationContext

    @Provides
    @Singleton
    @JvmStatic
    fun providesAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()

    @Provides
    @JvmStatic
    fun provideItemDao(appDatabase: AppDatabase) : ItemDao = appDatabase.itemDao()
}