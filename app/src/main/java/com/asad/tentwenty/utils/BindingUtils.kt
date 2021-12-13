package com.asad.tentwenty.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.asad.tentwenty.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingUtils {

    @JvmStatic
    @BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
    fun setImageUrl(
        imageView: ImageView,
        imageUrl: String,
        placeHolder: Int = R.drawable.ic_default
    ) {
        if (!TextUtils.isEmpty(imageUrl)) {
            val requestOptions = RequestOptions().placeholder(placeHolder).error(placeHolder)
            Glide.with(imageView.context)
                .load(CommonConstants.TMDB_IMAGE_BASE_URL.toString() + imageUrl)
                .apply(requestOptions)
                .into(imageView)
        }
    }
}