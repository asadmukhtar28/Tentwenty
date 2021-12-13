package com.asad.tentwenty.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asad.tentwenty.data.remote.models.base.State
import com.asad.tentwenty.data.remote.models.moviedetail.MovieDetailResponse
import com.asad.tentwenty.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(val repository: MovieDetailRepository) :
    ViewModel() {

    val isLoading = MutableLiveData(false)
    val playVideo = MutableLiveData(false)
    val moviePoster = MutableLiveData<String>("")
    val movieReleaseDate = MutableLiveData<String>()
    val movieTrailer = MutableLiveData<String>("")
    val movieOverview = MutableLiveData<String>()
    private val _fetchMovieDetailApiResponse = SingleLiveEvent<State<MovieDetailResponse>>()
    val movieDetailApiResponse: LiveData<State<MovieDetailResponse>> =
        _fetchMovieDetailApiResponse

    fun fetchMovieDetail(movieId: Int) {
        viewModelScope.launch {
            repository.fetchMovieDetail(movieId).collect {
                _fetchMovieDetailApiResponse.value = it
            }
        }
    }

    fun setMovieDetailData(movieModel: MovieDetailResponse) {
        moviePoster.value = movieModel.poster_path
        movieReleaseDate.value = movieModel.release_date
        movieOverview.value = movieModel.overview

        if (movieModel.videos != null && movieModel.videos.results.size > 0) {
            movieTrailer.value = "http://www.youtube.com/watchv=" + movieModel.videos.results[0].id
        }
    }

    fun onPlayTrailerClick() {
        movieTrailer.value?.let {
            playVideo.value = true
        }
    }
}