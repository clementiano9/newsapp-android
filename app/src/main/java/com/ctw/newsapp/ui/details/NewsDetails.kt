package com.ctw.newsapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ctw.model.Article
import com.ctw.newsapp.R

@Composable
fun NewsDetails(article: Article?, onBackPress: () -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.article)) },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = onBackPress) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }
                },
            )
        }
    ) {
        Column(
            Modifier
                .background(MaterialTheme.colors.background)
                .padding(it)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            if (article?.urlToImage != null) {
                Image(
                    painter = rememberAsyncImagePainter(model = article.urlToImage),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = article?.title ?: "",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(top = 18.dp, bottom = 24.dp)
            )
            Text(
                text = article?.description ?: "",
                Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.body2
            )
            Text(text = article?.content ?: "",
                fontSize = MaterialTheme.typography.body1.fontSize,
                modifier = Modifier.alpha(0.8f)
            )
        }

    }
}

@Preview
@Composable
fun NewsDetailsPreview() {
    NewsDetails(
        Article(
            title = "Title",
            description = "Description",
            content = "Content",
            url = "url",
            urlToImage = "urlToImage",
            publishedAt = "publishedAt",
            author = "author",
            source = com.ctw.model.Source(name = "source", id = "sourceId")
        ),
        onBackPress = {}
    )
}