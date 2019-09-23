package com.mobile.ingcodecase.core.presentation.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

/*
 * Loads image into current target
 */
fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}