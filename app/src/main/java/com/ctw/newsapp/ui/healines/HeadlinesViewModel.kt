package com.ctw.newsapp.ui.healines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctw.domain.GetHeadlinesUseCase
import com.ctw.model.Article
import com.ctw.model.HeadlinesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewState for Headline screen
 */
data class HeadlineViewState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean,
    val error: String? = null
)

/**
 * ViewModel for Headline screen
 */
class HeadlinesViewModel(
    private val getHeadlinesUseCase: GetHeadlinesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _viewState: MutableStateFlow<HeadlineViewState> =
        MutableStateFlow(HeadlineViewState(isLoading = true))
    val viewState = _viewState.asStateFlow()

    init {
        getHeadlines()
    }

    /**
     * Fetch headlines from the API
     */
    fun getHeadlines() {
        viewModelScope.launch(dispatcher) {
            try {
                val results = getHeadlinesUseCase()
                _viewState.update { it.copy(articles = results, isLoading = false) }
            } catch (e: Exception) {
                _viewState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}