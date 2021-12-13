package com.asad.tentwenty.ui.detail

import com.asad.tentwenty.data.remote.models.base.State
import com.asad.tentwenty.data.remote.models.moviedetail.MovieDetailResponse
import com.asad.tentwenty.managers.DataManager
import com.asad.tentwenty.ui.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MovieDetailRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {

    suspend fun fetchMovieDetail(movieId: Int): Flow<State<MovieDetailResponse>> {
        return flow {
            emit(State.loading<Nothing>())
            val result =
                makeApiCall { dataManager.getApiHelper().fetchMovieDetail(movieId.toString()) }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}