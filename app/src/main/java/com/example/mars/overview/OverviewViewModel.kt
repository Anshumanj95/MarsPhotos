package com.example.mars.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mars.network.MarsApi
import com.example.mars.network.MarsPhotos
import kotlinx.coroutines.launch

enum class MarsApiStatus{LOADING,SUCCESS,ERROR}

class OverviewViewModel: ViewModel(){

    private val _status=MutableLiveData<MarsApiStatus>()

    val status:LiveData<MarsApiStatus> =_status

    private val _photos=MutableLiveData<List<MarsPhotos>>()

    val photos:LiveData<List<MarsPhotos>> =_photos

    init {
        getMarsPhoto()
    }

    private fun getMarsPhoto(){
       viewModelScope.launch {
           _status.value=MarsApiStatus.LOADING
           try {
               _photos.value=MarsApi.retrofitService.getPhotos()
               _status.value=MarsApiStatus.SUCCESS
           }
           catch (e:Exception){
               _status.value=MarsApiStatus.ERROR
               _photos.value= listOf()
           }

       }
    }
}