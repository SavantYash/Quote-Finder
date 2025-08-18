package com.example.test123.model.retrofit

import com.example.test123.model.datamodel.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitApi {

    @Headers("X-Api-Key: loJcsba7Q8yfRnzYMd05bA==4LMfV005TohLItOI")
    @GET("quotes")
    suspend fun getQuote(): Array<ApiResponse>
}