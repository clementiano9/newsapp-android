package com.ctw.newsapp.ui.healines

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ctw.model.Article
import com.ctw.newsapp.R

@Composable
fun Headlines(viewModel: HeadlinesViewModel, onItemClick: (article: Article) -> Unit) {
    val viewState = viewModel.viewState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name), ) },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
            )
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)) {
            LazyColumn {
                items(viewState.value.articles) { article ->
                    ArticleItem(article = article, onClick = { onItemClick(article) })
                }
            }
        }
    }

}

/**
 * Article Item with image and headline
 */
@Composable
fun ArticleItem(article: Article, onClick: (Article) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable { onClick(article) }
    ) {
        if (article.urlToImage != null) {
            Image(
                painter = rememberAsyncImagePainter(model = article.urlToImage),
                contentDescription = null,
                Modifier
                    .size(80.dp)
                    .align(Alignment.CenterVertically)
                    .padding(end = 12.dp),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = article.title,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterVertically).alpha(0.8f),
        )
    }
}
