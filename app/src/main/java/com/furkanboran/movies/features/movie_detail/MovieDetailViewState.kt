package com.furkanboran.movies.features.movie_detail

import com.furkanboran.movies.common.api.ServerConstants
import com.furkanboran.movies.common.response.MovieDetailResponseModel
import com.furkanboran.movies.utils.DateUtils

data class MovieDetailViewState(
    val movie: MovieDetailResponseModel
) {
    fun getMoviePosterUrl() = ServerConstants.LOGO_BASE_URL.plus(movie.posterPath)

    fun getVoteAverage() = "${movie.voteAverage}"

    fun getReleaseDate() = DateUtils.convertApiDateToAppDate(movie.releaseDate)

    fun getTitle() = "${movie.originalTitle} (${DateUtils.convertApiDateToYear(movie.releaseDate)})}"

    fun getOverview() = movie.overview
}
