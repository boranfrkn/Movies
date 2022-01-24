package com.furkanboran.movies.base

import com.furkanboran.movies.common.response.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Singleton

@Singleton
abstract class BaseRepository {
    suspend fun <T : Any?> apiCall(call: suspend () -> T): Flow<Resource<T>> {
        return flow {
            try {
                this.emit(Resource.Loading)

                val response = call.invoke()

                when (response) {
                    null -> {
                        this.emit(
                            Resource.Error(
                                errorMessage = "Something wrong!"
                            )
                        )
                    }
                    else -> {
                        this.emit(
                            Resource.Success(response)
                        )
                    }
                }
            } catch (e: Exception) {
                this.emit(
                    Resource.Error(e.message ?: "")
                )
            }
        }
    }
}