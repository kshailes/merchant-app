package com.example.merchant.util.Network

import retrofit2.Response

sealed class Outcome<out T : Any> {
    data class Success<out T : Any>(val data: T) : Outcome<T>()
    data class Error(val error: GenericErrorResponse) : Outcome<Nothing>()
}

suspend fun <T : Any> apiCall(call: suspend() -> Response<T>): Outcome<T> {
    val response: Response<T>
    try {
        response = call.invoke()
    } catch (e: Exception) {
        e.printStackTrace()
        return Outcome.Error(GenericErrorResponse("NETWORK_ERROR", ""))
    }

    return try {
        if (response.isSuccessful) {
            Outcome.Success(response.body()!!)
        } else {
            Outcome.Error(GenericErrorResponse("NETWORK_ERROR", ""))
//            Outcome.Error(parseError(response.errorBody()))
        }
    } catch (e: Exception) {
        return Outcome.Error(GenericErrorResponse("UNKNOWN_ERROR", ""))
    }
}