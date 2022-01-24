package com.furkanboran.movies.features.home.data

import com.furkanboran.movies.base.BaseRepository
import com.furkanboran.movies.common.api.MoviesApi
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val moviesApi: MoviesApi
) : BaseRepository() {
    suspend fun getMovies() = apiCall {
        moviesApi.getPlayingMovies()
    }

    suspend fun getMoviesForSlider() = apiCall {
        moviesApi.getUpcomingMovies()
    }
}