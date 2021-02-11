package com.example.rentx.shared.providers.toasts

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.rentx.R
import kotlinx.android.synthetic.main.custom_toast.view.*

class ToastProvider(context: Context) : ConstraintLayout(context) {


    init {
        View.inflate(context, R.layout.custom_toast, this)
    }

    fun createToast(text: String, toastType: ToastType) {
        val toastColor = getToastColor(toastType)
        val toastIcon = getToastIcon(toastType)
        val toast = Toast(context)

        tv_toast_message.text = text
        iv_toast_icon.setImageDrawable(toastIcon)
        cl_toast_container.background = ContextCompat.getDrawable(context, toastColor)

        toast.apply {
            setGravity(Gravity.FILL_HORIZONTAL or Gravity.TOP, 0, 0)
            duration = Toast.LENGTH_LONG
        }
        toast.view = this

        toast.show()
    }

    private fun getToastColor(toastType: ToastType): Int {
        return when (toastType) {
            ToastType.ERROR -> R.color.red
            ToastType.SUCCESS -> R.color.green
            ToastType.INFO -> R.color.blue
        }
    }

    private fun getToastIcon(toastType: ToastType): Drawable? {
        return when (toastType) {
            ToastType.ERROR -> ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_error_triangle,
                null
            )

            ToastType.SUCCESS -> ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_check,
                null
            )

            ToastType.INFO -> ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_info,
                null
            )
        }
    }
}