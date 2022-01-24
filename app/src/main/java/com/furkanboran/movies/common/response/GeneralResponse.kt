package com.furkanboran.movies.common.response

import com.google.gson.annotations.SerializedName

data class GeneralResponse<T>(
    @SerializedName("date")
    val dates: Any?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: T,
    @SerializedName("total_pages")
    val total_pages: Int?,
    @SerializedName("total_results")
    val total_results: Int?,
    @SerializedName("status_code")
    val status_code: Int?,
    @SerializedName("status_message")
    val statusMessage: String?,
    @SerializedName("success")
    val success: Boolean?
)
