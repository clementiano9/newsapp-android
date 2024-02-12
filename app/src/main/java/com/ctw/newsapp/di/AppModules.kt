package com.ctw.newsapp.di

import com.ctw.data.network.RetrofitClient
import com.ctw.domain.GetHeadlinesUseCase
import com.ctw.data.repository.DefaultNewsRepository
import com.ctw.domain.repo.NewsRepository
import com.ctw.newsapp.BuildConfig
import com.ctw.newsapp.ui.healines.HeadlinesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single { GetHeadlinesUseCase(get()) }
}

val repositoryModule = module {
    single<NewsRepository> { DefaultNewsRepository(get(), BuildConfig.API_KEY) }
}

val networkModule = module {
    single { RetrofitClient().getApiService() }
}

val viewModule = module {
     viewModel { HeadlinesViewModel(get()) }
}

val appModules = listOf(useCaseModule, repositoryModule, networkModule, viewModule)