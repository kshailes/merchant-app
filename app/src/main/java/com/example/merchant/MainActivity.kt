package com.example.merchant

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.merchant.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var dataBinding: ActivityMainBinding

    @Inject
    lateinit var viewmodelproviderfactory: ViewModelProvider.Factory

    lateinit var viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewmodelproviderfactory).get(MainActivityViewModel::class.java)
        initNavigation()
        setupBottomNavigationTabs()
    }

    private fun initNavigation() {
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
                topLevelDestinationIds = setOf(
                        R.id.order_fragment,
                        R.id.menu_fragment,
                        R.id.profile_fragment,
                )
        )
        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    private fun setupBottomNavigationTabs() {
        dataBinding.bottomNavigationTab.setupWithNavController(navController)
    }
}