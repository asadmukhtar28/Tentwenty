package com.asad.tentwenty.ui.detail

import androidx.activity.viewModels
import com.asad.tentwenty.BR
import com.asad.tentwenty.R
import com.asad.tentwenty.data.remote.models.base.State
import com.asad.tentwenty.databinding.ActivityMovieDetailBinding
import com.asad.tentwenty.ui.base.BaseActivity
import com.asad.tentwenty.utils.CommonTags
import com.asad.tentwenty.utils.showShortToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_movie_detail.*
import android.net.Uri

import android.content.Intent
import android.text.TextUtils


@AndroidEntryPoint
class MovieDetailActivity :
    BaseActivity<MovieDetailViewModel, ActivityMovieDetailBinding>(R.layout.activity_movie_detail) {
    override val viewModel: MovieDetailViewModel by viewModels()

    override fun getBindingVariable() = BR.viewModel

    override fun initUi() {
        viewModel.playVideo.observe(this, {
            if (!TextUtils.isEmpty(viewModel.movieTrailer.value)) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.movieTrailer.value))
                startActivity(intent)
            }
        })

        viewModel.movieDetailApiResponse.observe(this, {
            when (it) {
                is State.Loading -> {
                    viewModel.isLoading.value = true
                }
                is State.Success -> {
                    viewModel.isLoading.value = false
                    it.wrapperData.let {
                        viewModel.setMovieDetailData(it)
                    }
                }
                is State.Error -> {
                    viewModel.isLoading.value = false
                    showShortToast("Error")
                }
            }
        })

        intent?.let {
            if (it.hasExtra(CommonTags.MOVIE_ID)) {
                val movieId = it.getIntExtra(CommonTags.MOVIE_ID, -1)
                viewModel.fetchMovieDetail(movieId)
            }
        }

    }

}