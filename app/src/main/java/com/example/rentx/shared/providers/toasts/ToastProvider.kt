package com.example.rentx.shared.providers.toasts

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.rentx.R
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.custom_toast.view.*

class ToastProvider {


    companion object {
        fun createToast(context: Context, toastType: ToastType, toastMessage: String) {
            val toast = when (toastType) {
                ToastType.ERROR -> DynamicToast.makeError(context, toastMessage, 2500)
                ToastType.SUCCESS -> DynamicToast.makeSuccess(context, toastMessage, 2500)
            }
            toast.setGravity(Gravity.TOP or Gravity.CENTER_VERTICAL, 0, 40)
            toast.show()
        }
    }
}