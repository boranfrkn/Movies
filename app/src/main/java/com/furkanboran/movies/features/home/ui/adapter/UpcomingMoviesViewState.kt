package com.furkanboran.movies.features.home.ui.adapter

import com.furkanboran.movies.common.api.ServerConstants
import com.furkanboran.movies.common.response.MoviesResponseModel
import com.furkanboran.movies.utils.DateUtils

data class UpcomingMoviesViewState(
   private val item: MoviesResponseModel
) {
    fun getMoviePosterUrl() = ServerConstants.LOGO_BASE_URL.plus(item.posterPath)

    fun getTitle() = "${item.title} (${DateUtils.convertApiDateToYear(item.releaseDate)})"

    fun getOverview() = item.overview

    fun getDate() = DateUtils.convertApiDateToAppDate(item.releaseDate)
}