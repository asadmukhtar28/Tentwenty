package com.asad.tentwenty.ui.base

import com.asad.tentwenty.R
import com.asad.tentwenty.data.remote.models.base.ResponseError
import com.asad.tentwenty.data.remote.models.base.State
import com.asad.tentwenty.managers.DataManager
import com.asad.tentwenty.utils.ApiResponseStatusCodes
import com.asad.tentwenty.utils.NetworkUtils
import retrofit2.Response

open class BaseRepository(val dataManager: DataManager) {

    suspend fun <T : Any> makeApiCall(
        apiCall: suspend () -> Response<T>,
    ): State<T> {
        return verifySessionAndMakeApiCall(apiCall, false)
    }

    private suspend fun isNetworkNotAvailable(): Boolean {
        var isConnected = true
        if (!NetworkUtils.isNetworkConnected(dataManager.getResourceManager().getContext())) {
            isConnected = false
        }
        return !isConnected
    }

    private suspend fun <T : Any> verifySessionAndMakeApiCall(
        call: suspend () -> Response<T>,
        verifySession: Boolean = true,
    ): State<T> {
        if (isNetworkNotAvailable()) {
            return State.Error(
                ResponseError(
                    ApiResponseStatusCodes.INTERNET_NOT_AVAILABLE,
                    dataManager.getResourceManager().getString(
                        R.string.internet_error
                    )
                )
            )
        }

        return apiOutput(call)

    }

    private suspend fun <T : Any> apiOutput(
        call: suspend () -> Response<T>,
    ): State<T> {
        val response = call.invoke()
        return if (response.isSuccessful)
            State.Success(response.body()!!)
        else {
            State.Error(ResponseError(response.code(), response.message()))
        }
    }
}