package com.example.test123.model.retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object ApiObject  {

    private const val BASE_URL = "https://api.api-ninjas.com/v1/"

    val retrofit : RetrofitApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitApi::class.java)
}