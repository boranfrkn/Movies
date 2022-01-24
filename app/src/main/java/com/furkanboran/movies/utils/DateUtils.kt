package com.furkanboran.movies.utils

import java.text.SimpleDateFormat
import java.util.*


object DateUtils {
    private val apiDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    private val appDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.US)
    private val yearFormat = SimpleDateFormat("yyyy", Locale.US)

    fun convertApiDateToAppDate(apiDate: String?): String {
        apiDate?.let {
            val newDate = apiDateFormat.parse(apiDate)
            newDate?.let {
                return appDateFormat.format(newDate)
            }
        }
        return "N/A"
    }

    fun convertApiDateToYear(apiDate: String?): String {
        apiDate?.let {
            val newDate = apiDateFormat.parse(apiDate)
            newDate?.let {
                return yearFormat.format(newDate)
            }
        }
        return "N/A"
    }
}