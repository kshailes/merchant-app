package com.example.merchant.util.di

import com.example.merchant.additem.AddItemFragment
import com.example.merchant.additem.AddItemViewModel
import com.example.merchant.menu.MenuFragment
import com.example.merchant.orders.OrderFragment
import com.example.merchant.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsInjectionModule {
    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributeOrderFragment(): OrderFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributeAddItemFragment(): AddItemFragment
}