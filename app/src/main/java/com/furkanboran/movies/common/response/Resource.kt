package com.furkanboran.movies.common.response

sealed class Resource<out T> {

    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val errorMessage: String = "") : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

/**
 * `true` if [MoviesResponseModel] is of type [Success] & holds non-null [Success.data].
 */
val Resource<*>.succeeded
    get() = this is Resource.Success && data != null