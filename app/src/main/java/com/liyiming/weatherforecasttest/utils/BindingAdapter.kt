package com.liyiming.weatherforecasttest.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imgUrl")
fun loadImage(view: ImageView, image_url: String) {
    Glide.with(view).load(image_url).into(view)
}
