package com.furkanboran.movies.features.movie_detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.furkanboran.movies.base.BaseViewModel
import com.furkanboran.movies.common.response.MovieDetailResponseModel
import com.furkanboran.movies.common.response.Resource
import com.furkanboran.movies.features.movie_detail.data.MovieDetailRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) : BaseViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetailResponseModel>()
    val movieDetail: LiveData<MovieDetailResponseModel> = _movieDetail

    fun getMovieDetail(movieId: Int){
        viewModelScope.launch {
            movieDetailRepository.getMovieDetail(movieId).collect { resource ->
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
                        _movieDetail.postValue(resource.data)
                    }
                }
            }
        }
    }
}