package com.example.myjepckmvvm.base

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myjepckmvvm.DialogLoadingUtils

open class BaseNormalKtActivity : AppCompatActivity() {

    private var mLoadingDialog: Dialog? = null


    /** 显示用户等待框  */
    protected fun showLoadingDialog(msg: String? = "") {
        mLoadingDialog = DialogLoadingUtils.createLoadingDialog(this, msg)
        mLoadingDialog?.let {
            it.show()
        }
    }

    /** 隐藏等待框  */
    protected fun dismissLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog!!.isShowing) {
            mLoadingDialog!!.dismiss()
            mLoadingDialog = null
        }
    }

}