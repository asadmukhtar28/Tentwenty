package com.asad.tentwenty.ui.main.watch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asad.tentwenty.data.remote.models.base.State
import com.asad.tentwenty.data.remote.models.movie.MovieResponse
import com.asad.tentwenty.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchViewModel @Inject constructor(val repository: WatchRepository) : ViewModel() {

    val isLoading = MutableLiveData(false)
    private val _fetchMoviesApiResponse = SingleLiveEvent<State<MovieResponse>>()
    val fetchMoviesApiResponse: LiveData<State<MovieResponse>> = _fetchMoviesApiResponse

    fun fetchMovies() {
        viewModelScope.launch {
            repository.fetchMovies().collect {
                _fetchMoviesApiResponse.value = it
            }
        }
    }
}