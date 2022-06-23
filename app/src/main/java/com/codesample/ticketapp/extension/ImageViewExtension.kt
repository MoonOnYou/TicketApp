package com.codesample.ticketapp.extension

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.codesample.ticketapp.R

fun ImageView.drawProgress(
    stroke: Float = 5f,
    centerRadius: Float = 30f
): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = stroke
    circularProgressDrawable.centerRadius = centerRadius
    circularProgressDrawable.setColorSchemeColors(ContextCompat.getColor( context , R.color.gray))
    circularProgressDrawable.start()
    return circularProgressDrawable
}

@BindingAdapter("image_url")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(context).load(url).placeholder(drawProgress()).error(R.drawable.ic_baseline_broken_image_24).into(this)
}