package com.furkanboran.movies.common.response


import com.google.gson.annotations.SerializedName

data class PlayingMoviesResponseModel(
    @SerializedName("dates")
    val dates: Dates?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MoviesResponseModel>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)