package com.furkanboran.movies.utils.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.openBrowser(link: String) {
    this.startActivity(Intent(Intent.ACTION_VIEW).apply { this.data = Uri.parse(link) })
}