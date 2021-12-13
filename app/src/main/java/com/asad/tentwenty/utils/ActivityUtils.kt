package com.asad.tentwenty.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

fun <T> Activity.launchActivity(
    context: Context,
    activityName: Class<T>,
    isFinish: Boolean = false,
    bundle: Bundle? = null
) {
    val intent = Intent(context, activityName)
    bundle?.let {
        intent.putExtras(bundle)
    }
    this.startActivity(intent)
    if (isFinish)
        this.finish()
}

fun <T> Activity.launchActivityForResult(
    activityName: Class<T>,
    bundle: Bundle? = null,
    requestCode: Int = -1
) {
    val intent = Intent(this, activityName)
    bundle?.let {
        intent.putExtras(bundle)
    }
    this.startActivityForResult(intent, requestCode)
}