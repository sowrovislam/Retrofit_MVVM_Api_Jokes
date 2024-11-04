package com.example.retrofit_datalistformvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_datalistformvvm.apiservice.JokesClient
import com.example.retrofit_datalistformvvm.data.ResponseJoks
import kotlinx.coroutines.launch

class JokesViewmodel:ViewModel(){

    private val JokesData=MutableLiveData<ResponseJoks>()

    val _jokesData
        get() =JokesData


    init {

        getRandamJokes()
    }



    fun getRandamJokes(){

        viewModelScope.launch {

            val response=JokesClient.jokesApiservice.getJokes()

            if (response.isSuccessful){
                JokesData.postValue(response.body())
            }


        }
    }

}