package com.ctw.data.repository

import com.ctw.data.ApiInterface
import com.ctw.domain.repo.NewsRepository
import com.ctw.model.HeadlinesResponse

class DefaultNewsRepository(private val apiInterface: ApiInterface, private val apiKey: String) : NewsRepository {
    override suspend fun getHeadlines(): HeadlinesResponse {
        return apiInterface.getHeadlines(apiKey)
    }
}