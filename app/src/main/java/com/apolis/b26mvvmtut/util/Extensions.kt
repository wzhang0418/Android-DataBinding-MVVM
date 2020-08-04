package com.apolis.b26mvvmtut.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hb.b26mvvmtut.R

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?) {
    Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_baseline_supervised_user_circle_24)
            .into(this)
}