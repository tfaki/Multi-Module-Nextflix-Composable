package com.talhafaki.nextflixcomposable.ui.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.talhafaki.domain.entity.NetworkMovie
import com.talhafaki.nextflixcomposable.ui.common.GridItem
import com.talhafaki.nextflixcomposable.ui.theme.NextflixComposableTheme

/**
 * Created by tfakioglu on 12.December.2021
 */
@Composable
fun PopularScreen() {

    val viewModel = hiltViewModel<PopularViewModel>()

    NextflixComposableTheme(darkTheme = true) {
        Column(Modifier.background(Color.DarkGray)) {
            PopularList(movieList = viewModel.getPopularList().collectAsLazyPagingItems())
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularList(movieList: LazyPagingItems<NetworkMovie>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(movieList.itemCount) { index ->
            movieList[index]?.let {
                GridItem(movie = it)
            }
        }
    }
}
