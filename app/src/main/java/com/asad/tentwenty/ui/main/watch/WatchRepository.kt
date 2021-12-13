package com.asad.tentwenty.ui.main.watch

import com.asad.tentwenty.data.remote.models.base.State
import com.asad.tentwenty.data.remote.models.movie.MovieResponse
import com.asad.tentwenty.managers.DataManager
import com.asad.tentwenty.ui.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class WatchRepository @Inject constructor(dataManager: DataManager) : BaseRepository(dataManager) {

    suspend fun fetchMovies(): Flow<State<MovieResponse>> {
        return flow {
            emit(State.loading<Nothing>())
            val result = makeApiCall { dataManager.getApiHelper().fetchUpComingMovies() }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}