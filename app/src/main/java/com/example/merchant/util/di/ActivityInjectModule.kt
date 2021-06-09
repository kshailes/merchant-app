package com.example.merchant.util.di

import com.example.merchant.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectModule {

    @ContributesAndroidInjector(
        modules = [FragmentsInjectionModule::class]
    )
    abstract fun mainActivity(): MainActivity
}