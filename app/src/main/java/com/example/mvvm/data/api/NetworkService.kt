package com.example.mvvm.data.api

import com.example.mvvm.data.model.TopHeadlinesResponse
import com.example.mvvm.utils.AppConstant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton



    @Singleton
    interface NetworkService {

        @Headers("X-Api-Key: $API_KEY")
        @GET("top-headlines")
        suspend fun getTopHeadlines(@Query("country") country: String): TopHeadlinesResponse

    }
