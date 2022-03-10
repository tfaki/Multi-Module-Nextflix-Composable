package com.talhafaki.popular

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.talhafaki.common.items.GridItem
import com.talhafaki.common.theme.NextflixComposableTheme
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError
import com.talhafaki.domain.entity.NetworkMovie

/**
 * Created by tfakioglu on 12.December.2021
 */
@Composable
fun PopularScreen() {
    val viewModel = hiltViewModel<PopularViewModel>()

    NextflixComposableTheme(darkTheme = true) {
        PopularList(movieList = viewModel.getPopularList().collectAsLazyPagingItems())
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularList(movieList: LazyPagingItems<NetworkMovie>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.background(color = Color.DarkGray),
        content = {
        items(movieList.itemCount) { index ->
            movieList[index]?.let { movie ->
                GridItem(
                    posterPath = movie.posterUrl,
                    title = movie.title,
                    desc = movie.overview
                )
            }
        }

        movieList.apply {
            val error = when {
                loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                else -> null
            }

            val loading = when {
                loadState.prepend is LoadState.Loading -> loadState.prepend as LoadState.Loading
                loadState.append is LoadState.Loading -> loadState.append as LoadState.Loading
                loadState.refresh is LoadState.Loading -> loadState.refresh as LoadState.Loading
                else -> null
            }

            if (loading != null) {
                //TODO: add loading
            }

            if (error != null) {
                //TODO: add error handler
                item { SweetError(message = error.error.localizedMessage ?: "Error") }
            }
        }
    })
}
