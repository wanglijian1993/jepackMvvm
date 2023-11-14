package com.example.myjepckmvvm

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView

/**
 * 加载中的dialog
 */
object DialogLoadingUtils {
    /**
     * 创建dialog
     *
     * @param context 上下文
     * @param msg 显示的加载中的文字
     * @return dialog
     */
    /** 创建dialog  */
    @JvmStatic
    fun createLoadingDialog(context: Context, msg: String? = ""): Dialog {
        val inflater = LayoutInflater.from(context)
        // 得到加载view
        val loadingView = inflater.inflate(R.layout.base_dialog_loading_kt, null)
        // 加载布局
        val llLoadingContent = loadingView.findViewById<LinearLayout>(R.id.ll_loadingContent)
        // 提示文字
        val tvShowMes = loadingView.findViewById<TextView>(R.id.tv_showMes)
        if (!TextUtils.isEmpty(msg)) {
            // 设置加载信息
            tvShowMes.text = msg
        }
        // 创建自定义样式dialog
        val loadingDialog = Dialog(context, R.style.BaseLoadingDialogStyle)
        // 是否可以按“返回键”消失
        loadingDialog.setCancelable(true)
        // 点击加载框以外的区域
        loadingDialog.setCanceledOnTouchOutside(false)
        // 设置布局
        loadingDialog.setContentView(
            llLoadingContent,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
        // 将显示Dialog的方法封装在这里面
        val window = loadingDialog.window
        val lp: WindowManager.LayoutParams
        if (window != null) {
            smoothScreen(window)
            lp = window.attributes
            lp.width = WindowManager.LayoutParams.WRAP_CONTENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            window.setGravity(Gravity.CENTER)
            window.attributes = lp
        }
        loadingDialog.show()
        return loadingDialog
    }

    private fun smoothScreen(window: Window) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
    }

    /** 关闭dialog  */
    @JvmStatic
    fun closeDialog(dialog: Dialog) {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }
}