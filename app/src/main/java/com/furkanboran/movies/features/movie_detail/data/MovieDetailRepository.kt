package com.furkanboran.movies.features.movie_detail.data

import com.furkanboran.movies.base.BaseRepository
import com.furkanboran.movies.common.api.MoviesApi
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(
    private val moviesApi: MoviesApi
) : BaseRepository(){
    suspend fun getMovieDetail(movieId: Int) = apiCall {
        moviesApi.getMovieDetail(movieId)
    }
}