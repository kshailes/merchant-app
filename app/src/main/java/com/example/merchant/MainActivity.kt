package com.example.merchant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavView: BottomNavigationView
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.bottom_navigation_tab)
        init()
        setupViews()


    }

    private fun init() {
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        var appBarConfiguration = AppBarConfiguration(
                topLevelDestinationIds = setOf (
                        R.id.home_fragment,
                        R.id.profile_fragment,
                )
        )
        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    private fun setupViews() {
        bottomNavView.setupWithNavController(navController)
    }
}