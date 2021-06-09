package com.example.merchant.util

import android.content.Context
import androidx.multidex.MultiDex
import com.example.merchant.util.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class MyApplication : DaggerApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication?> {
        return DaggerAppComponent.builder().application(this).build()
    }
}