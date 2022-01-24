package com.furkanboran.movies.features.movie_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.furkanboran.movies.R
import com.furkanboran.movies.base.BaseFragment
import com.furkanboran.movies.common.api.ServerConstants
import com.furkanboran.movies.common.ui.LayoutErrorViewState
import com.furkanboran.movies.common.ui.LayoutLoadingViewState
import com.furkanboran.movies.databinding.FragmentMovieDetailBinding
import com.furkanboran.movies.utils.extensions.openBrowser

class MovieDetailFragment : BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>() {

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_movie_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var movieId = requireArguments().getInt("movie_id")
        binding.apply {
            viewModel.apply {
                getMovieDetail(movieId)

                responseLoading.observe(viewLifecycleOwner, {
                    binding.loadingIncluded.viewState = LayoutLoadingViewState(it)
                })

                responseError.observe(viewLifecycleOwner, {
                    binding.errorIncluded.viewState = LayoutErrorViewState(it)
                })

                movieDetail.observe(viewLifecycleOwner, { movieDetail ->
                    viewState = MovieDetailViewState(movieDetail)

                    ivDetailImdb.setOnClickListener {
                        requireContext().openBrowser(ServerConstants.IMDB_URL.plus(movieDetail.imdbİd))
                    }
                })


            }
        }
    }

}