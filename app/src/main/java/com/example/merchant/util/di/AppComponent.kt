package com.example.merchant.util.di

import com.example.merchant.util.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    NetworkModule::class,
    AppModule::class,
    ViewModelsModule::class,
    ActivityInjectModule::class])
interface AppComponent: AndroidInjector<MyApplication> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build():AppComponent
    }
}