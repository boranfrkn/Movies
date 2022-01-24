package com.furkanboran.movies.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("hasFixedSize")
fun RecyclerView.hasFixedSize(hasFixedSize: Boolean) {
    this.setHasFixedSize(hasFixedSize)
}

@BindingAdapter("verticalDivider")
fun RecyclerView.verticalDivider(verticalDivider: Drawable) {
    addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL).also {
        it.setDrawable(verticalDivider)
    })
}

@BindingAdapter(value = ["url"])
fun ImageView.url(url: String?) {
    if (url.isNullOrEmpty().not()) {
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("isVisible")
fun isVisibleOrGone(view: View, isVisible: Boolean) {
    if (isVisible) view.visibility = View.VISIBLE else view.visibility = View.GONE
}