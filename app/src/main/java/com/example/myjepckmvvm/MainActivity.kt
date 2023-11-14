package com.example.myjepckmvvm

import android.os.Bundle
import com.example.myjepckmvvm.base.BaseKtActivity
import com.example.myjepckmvvm.databinding.ActivityMainBinding
import com.example.myjepckmvvm.mvvm.MainViewModel

class MainActivity : BaseKtActivity<ActivityMainBinding, MainViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun initView() {
    }

    override fun initData() {

    }

}