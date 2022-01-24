package com.furkanboran.movies.features.home.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.furkanboran.movies.R
import com.furkanboran.movies.common.api.ServerConstants
import com.furkanboran.movies.common.response.MoviesResponseModel
import com.furkanboran.movies.common.response.PlayingMoviesResponseModel
import com.furkanboran.movies.utils.DateUtils

class SliderAdapter(
    private val context: Context,
    private val movies: PlayingMoviesResponseModel,
    private val clickListener: (MoviesResponseModel) -> Unit
) : PagerAdapter() {
    override fun getCount(): Int {
        return movies.results?.size ?: 0
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    @SuppressLint("SetTextI18n")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val view: ViewGroup =
            layoutInflater.inflate(R.layout.item_slider, container, false) as ViewGroup


        val circularProgress = CircularProgressDrawable(context)
        circularProgress.strokeWidth = 5f
        circularProgress.centerRadius = 30f
        circularProgress.start()

        movies.results?.get(position)?.let {
            Glide.with(context)
                .load(ServerConstants.LOGO_BASE_URL.plus(it.backdropPath))
                .placeholder(circularProgress)
                .into(view.findViewById(R.id.ivItemSlider))
            view.findViewById<TextView>(R.id.tvItemSliderTitle).text = it.title + " (${DateUtils.convertApiDateToYear(it.releaseDate)})"
            view.findViewById<TextView>(R.id.tvItemSliderDesc).text = it.overview

        }

        view.setOnClickListener {
            movies.results?.get(position)?.let { movie -> clickListener(movie) }
        }

        container.addView(view)
        return view
    }
}