package com.ctw.data

import com.ctw.model.HeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    suspend fun getHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String = "us"
    ): HeadlinesResponse
}