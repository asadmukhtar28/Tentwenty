package com.asad.tentwenty.data.remote.models.base

/**
 * State Management for UI & Data.
 */
sealed class State<out T> {

    data class Success<T>(val wrapperData: T) : State<T>()

    data class Error(val responseError: ResponseError) : State<Nothing>()

    data class Loading(val wrapperData: Nothing? = null) : State<Nothing>()

    companion object {

        /**
         * Returns [State.Success] instance.
         * @param data Data to emit with status.
         */
        fun <T> success(data: T) = Success(data)

        /**
         * Returns [State.Error] instance.
         * @param message Description of failure.
         */
        fun <T> error(responseError: ResponseError) =
            Error(responseError)

        fun <Nothing> loading() = Loading()
    }
}
