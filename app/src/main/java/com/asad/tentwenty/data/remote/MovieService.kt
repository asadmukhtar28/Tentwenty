package com.asad.tentwenty.data.remote

import com.asad.tentwenty.BuildConfig
import com.asad.tentwenty.data.remote.models.movie.MovieResponse
import com.asad.tentwenty.data.remote.models.moviedetail.MovieDetailResponse
import com.asad.tentwenty.utils.CommonConstants.TMDB_VIDEOS_IMAGES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("upcoming")
    suspend fun fetchUpComingMovies(@Query("api_key") key: String = BuildConfig.ApiKey): Response<MovieResponse>

    @GET("{id}")
    suspend fun fetchMovieDetail(
        @Path("id") id: String, @Query("api_key") key: String = BuildConfig.ApiKey,
        @Query("") videos: String = TMDB_VIDEOS_IMAGES
    ): Response<MovieDetailResponse>
}
