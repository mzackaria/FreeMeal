package com.messai.freemeal.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.messai.freemeal.R
import com.squareup.picasso.Picasso


@BindingAdapter("picasso")
fun ImageView.picasso(url: String?){
    url?.let {
        Picasso.with(this.context)
            .load(url)
            .placeholder(R.drawable.placeholder_meal_picture)
            .error(R.drawable.ic_broken_image)
            .into(this)
    }
}