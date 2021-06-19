package com.example.merchant.util.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.merchant.MainActivityViewModel
import com.example.merchant.additem.AddItemViewModel
import com.example.merchant.menu.MenuViewModel
import com.example.merchant.orders.OrderViewModel
import com.example.merchant.profile.ProfileViewModel
import com.example.merchant.util.ViewModelProviderFactory
import com.example.merchant.util.ViewModelsKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelsModule {
    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        fun viewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory =
            factory
    }

    @Binds
    @IntoMap
    @ViewModelsKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainActivityViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelsKey(OrderViewModel::class)
    abstract fun bindOrderViewModel(viewModel: OrderViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelsKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(viewModel: MenuViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelsKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelsKey(AddItemViewModel::class)
    abstract fun bindAddItemViewModel(viewModel: AddItemViewModel): ViewModel
}