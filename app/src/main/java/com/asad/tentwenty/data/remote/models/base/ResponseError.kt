package com.asad.tentwenty.data.remote.models.base

data class ResponseError(
    var statusCode: Int? = null,
    var errorMessage: String? = null
)