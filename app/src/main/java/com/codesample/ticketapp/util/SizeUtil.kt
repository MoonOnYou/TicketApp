package com.codesample.ticketapp.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

@SuppressLint("StaticFieldLeak")
object SizeUtil {
    private var context : Context? = null

    fun initWith(context: Context) {
        this.context = context
    }

    fun convertDpToPixel(dp: Float): Float {
        return if (context != null) {
            val resources = context!!.resources
            val metrics = resources.displayMetrics
            dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        } else {
            val metrics = Resources.getSystem().displayMetrics
            dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
        }
    }
}