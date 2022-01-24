package com.furkanboran.movies.common.api

import com.furkanboran.movies.common.response.MovieDetailResponseModel
import com.furkanboran.movies.common.response.PlayingMoviesResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = ServerConstants.API_KEY
    ): MovieDetailResponseModel

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int? = 1,
        @Query("api_key") apiKey: String = ServerConstants.API_KEY
    ): PlayingMoviesResponseModel

    @GET("movie/now_playing")
    suspend fun getPlayingMovies(
        @Query("api_key") apiKey: String = ServerConstants.API_KEY,
    ): PlayingMoviesResponseModel
}