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

    }

    override fun initData() {

    }

}