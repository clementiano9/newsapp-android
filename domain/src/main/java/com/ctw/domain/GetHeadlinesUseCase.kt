package com.ctw.domain

import com.ctw.domain.repo.NewsRepository

class GetHeadlinesUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke() = repository.getHeadlines().articles
}