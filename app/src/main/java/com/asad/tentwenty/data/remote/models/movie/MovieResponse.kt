package com.asad.tentwenty.data.remote.models.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val dates: Dates,
    val page: Int,
    @SerializedName("results")
    val movieModels: List<MovieModel>,
    val total_pages: Int,
    val total_results: Int
)