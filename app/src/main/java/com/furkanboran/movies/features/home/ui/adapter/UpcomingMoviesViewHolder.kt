package com.furkanboran.movies.features.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.furkanboran.movies.R
import com.furkanboran.movies.common.response.MoviesResponseModel
import com.furkanboran.movies.databinding.ItemUpcomingBinding
import com.furkanboran.movies.features.home.ui.HomeFragmentDirections

class UpcomingMoviesViewHolder(private val binding: ItemUpcomingBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MoviesResponseModel) {
        binding.viewState = UpcomingMoviesViewState(item)
        binding.executePendingBindings()
        var navController: NavController? = null
        binding.root.setOnClickListener {
            navController = Navigation.findNavController(it)
            navController?.navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(item.id?: 0))
        }
    }

    companion object {
        fun create(parent: ViewGroup): UpcomingMoviesViewHolder{
            val binding: ItemUpcomingBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_upcoming,
                parent,
                false
            )
            return UpcomingMoviesViewHolder(binding)
        }
    }
}