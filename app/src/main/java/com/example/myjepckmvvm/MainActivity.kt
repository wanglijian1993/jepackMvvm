package com.example.myjepckmvvm

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myjepckmvvm.base.BaseKtActivity
import com.example.myjepckmvvm.databinding.ActivityMainBinding
import com.example.myjepckmvvm.mvvm.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseKtActivity<ActivityMainBinding, MainViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun initView() {
        val navView: BottomNavigationView = binding.bottomNav
        val navController = findNavController(R.id.nav_host_container)
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.home)
                }

                R.id.navigation_dashboard -> {
                    navController.navigate(R.id.dashboard)

                }

                R.id.navigation_notifications -> {
                    navController.navigate(R.id.notification)

                }
            }
            true
        }

    }

    override fun initData() {


    }

}