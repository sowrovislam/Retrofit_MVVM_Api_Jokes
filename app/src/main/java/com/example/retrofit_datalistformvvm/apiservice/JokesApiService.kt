package com.example.retrofit_datalistformvvm.apiservice

import com.example.retrofit_datalistformvvm.data.ResponseJoks
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JokesApiService {

    //    https://v2.jokeapi.dev/joke/Any


    @GET("joke/Any")
    suspend fun getJokes():Response<ResponseJoks>

}

object  JokesClient{

    val retrofit=Retrofit.Builder()
        .baseUrl("https://v2.jokeapi.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val jokesApiservice= retrofit.create(JokesApiService::class.java)



}