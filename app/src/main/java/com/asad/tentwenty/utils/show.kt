package com.asad.tentwenty.utils

import android.content.Context
import android.widget.SearchView
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow

fun Context.showShortToast(message: String) {
    Toast.makeText(
        this, message,
        Toast.LENGTH_SHORT
    ).show()
}

fun Context.showLongToast(message: String) {
    Toast.makeText(
        this, message,
        Toast.LENGTH_LONG
    ).show()
}
