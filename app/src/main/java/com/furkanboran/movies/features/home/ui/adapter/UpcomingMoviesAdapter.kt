package com.furkanboran.movies.features.home.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.furkanboran.movies.common.response.MoviesResponseModel

class UpcomingMoviesAdapter : RecyclerView.Adapter<UpcomingMoviesViewHolder>() {

    private val items = arrayListOf<MoviesResponseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesViewHolder =
        UpcomingMoviesViewHolder.create(parent)

    override fun onBindViewHolder(holder: UpcomingMoviesViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun updateData(items: List<MoviesResponseModel>) {
        this.items.clear()
        this.items.addAll(items)
        if(this.items.isEmpty()) notifyItemRangeInserted(this.items.size.minus(items.size), items.size) else notifyDataSetChanged()
    }
}