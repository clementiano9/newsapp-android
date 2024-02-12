package com.ctw.domain.repo

import com.ctw.model.HeadlinesResponse

interface NewsRepository {
    suspend fun getHeadlines(): HeadlinesResponse
}
