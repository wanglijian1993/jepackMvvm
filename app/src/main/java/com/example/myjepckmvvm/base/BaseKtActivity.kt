package com.example.myjepckmvvm.base


import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

open abstract class BaseKtActivity<VB : ViewBinding, VM : BaseViewModel> :
    BaseNormalKtActivity() {

    private lateinit var _binding: VB
    protected val binding get() = _binding

    protected lateinit var mViewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(_binding.root)
        mViewModel = initViewModel()
        initView()
        initData()
    }

    abstract fun initData()

    abstract fun initView()


    private fun getViewBinding(): VB {
        var superclass: Type = this.javaClass.genericSuperclass
        var aClass: Class<VB> =
            (superclass as ParameterizedType).actualTypeArguments[0] as Class<VB>

        try {
            val method = aClass.getMethod("inflate", LayoutInflater::class.java)
            _binding = method.invoke(null, layoutInflater) as VB
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return _binding
    }


    private fun initViewModel(): VM {
        var superclass: Type = this.javaClass.genericSuperclass

        var vClass: Class<VM> =
            (superclass as ParameterizedType).actualTypeArguments[1] as Class<VM>

        try {
            mViewModel = ViewModelProvider(this)[vClass]

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return mViewModel
    }


}