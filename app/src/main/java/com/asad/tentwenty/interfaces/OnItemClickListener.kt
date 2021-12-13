package com.asad.tentwenty.interfaces

import com.asad.tentwenty.data.remote.models.movie.MovieModel

interface OnItemClickListener {
    fun onItemClick(model: MovieModel)
}