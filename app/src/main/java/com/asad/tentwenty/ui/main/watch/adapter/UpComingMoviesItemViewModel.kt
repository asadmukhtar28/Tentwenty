package com.asad.tentwenty.ui.main.watch.adapter

import androidx.lifecycle.MutableLiveData
import com.asad.tentwenty.data.remote.models.movie.MovieModel

class UpComingMoviesItemViewModel(model: MovieModel, val listener: OnItemClickListener) {
    val name = MutableLiveData(model.title)
    val image = MutableLiveData(model.poster_path)

    fun onItemClick() {
        listener.onItemClick()
    }


    interface OnItemClickListener {
        fun onItemClick()
    }
}