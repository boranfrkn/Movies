package com.furkanboran.movies.features.home.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.furkanboran.movies.base.BaseViewModel
import com.furkanboran.movies.common.response.Resource
import com.furkanboran.movies.common.response.PlayingMoviesResponseModel
import com.furkanboran.movies.features.home.data.MoviesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
)  : BaseViewModel() {

    private val _movies = MutableLiveData<PlayingMoviesResponseModel>()
    val movies : LiveData<PlayingMoviesResponseModel> = _movies

    private val _moviesForSlider = MutableLiveData<PlayingMoviesResponseModel>()
    val moviesForSlider: LiveData<PlayingMoviesResponseModel> = _moviesForSlider

    fun getMovies(){
        viewModelScope.launch {
            moviesRepository.getMovies().collect { resource ->
                when(resource){
                    is Resource.Error -> {
                        setErrorState()
                    }
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        setNotLoadingState()
                        Log.e("test", "${resource.data}")
                        _movies.postValue(resource.data)
                    }
                }
            }
        }
    }

    fun getMoviesForSlider(){
        viewModelScope.launch {
            moviesRepository.getMoviesForSlider().collect { resource ->
                when(resource){
                    is Resource.Error -> {
                        setErrorState()
                        setNotLoadingState()
                        Log.e("error", "${resource.errorMessage}")
                    }
                    is Resource.Loading -> {
                        setLoadingState()
                        Log.e("loading", "true")
                    }
                    is Resource.Success -> {
                        setNotLoadingState()
                        Log.e("test", "${resource.data}")
                        _moviesForSlider.postValue(resource.data)
                    }
                }
            }
        }
    }
}