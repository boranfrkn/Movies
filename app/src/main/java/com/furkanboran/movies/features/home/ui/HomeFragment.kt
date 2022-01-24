package com.furkanboran.movies.features.home.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.furkanboran.movies.R
import com.furkanboran.movies.base.BaseFragment
import com.furkanboran.movies.common.ui.LayoutErrorViewState
import com.furkanboran.movies.common.ui.LayoutLoadingViewState
import com.furkanboran.movies.databinding.FragmentHomeBinding
import com.furkanboran.movies.features.home.ui.adapter.SliderAdapter
import com.furkanboran.movies.features.home.ui.adapter.UpcomingMoviesAdapter
import javax.inject.Inject

class HomeFragment @Inject constructor() : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_home

    lateinit var upcomingMoviesAdapter: UpcomingMoviesAdapter

    var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tlHomeFragment.setupWithViewPager(binding.vpFragmentHome, true)
        navController = Navigation.findNavController(binding.root)
        upcomingMoviesAdapter = UpcomingMoviesAdapter()
        binding.apply {
            rvHomeFragment.adapter = upcomingMoviesAdapter


            viewModel.apply {
                getMoviesForSlider()
                responseLoading.observe(viewLifecycleOwner, {
                    binding.loadingIncluded.viewState = LayoutLoadingViewState(it)
                })

                responseError.observe(viewLifecycleOwner, {
                    binding.errorIncluded.viewState = LayoutErrorViewState(it)
                })

                moviesForSlider.observe(viewLifecycleOwner, { result ->
                    vpFragmentHome.adapter =
                        SliderAdapter(requireContext(), result) { movie ->
                            navController?.navigate(
                                HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                                    movie.id ?: 0
                                )
                            )
                        }
                    srHomeFragment.isRefreshing = false
                })

                srHomeFragment.setOnRefreshListener {
                    getMoviesForSlider()
                }

                getMovies()
                movies.observe(viewLifecycleOwner, {
                    it.results?.let { response -> upcomingMoviesAdapter.updateData(response) }
                })
            }
        }
    }


}