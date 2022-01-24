package com.furkanboran.movies.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _responseLoading = MutableLiveData<Boolean>()
    val responseLoading : LiveData<Boolean> = _responseLoading

    private val _responseError = MutableLiveData<Boolean>()
    val responseError : LiveData<Boolean> = _responseError

    fun setLoadingState() = _responseLoading.postValue(true)

    fun setNotLoadingState() = _responseLoading.postValue(false)

    fun setErrorState() = _responseError.postValue(true)
}