package com.talhafaki.nowplaying

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.talhafaki.common.items.MovieItem
import com.talhafaki.common.theme.NextflixComposableTheme
import com.talhafaki.composablesweettoast.main.SweetToast
import com.talhafaki.composablesweettoast.util.SweetToastUtil
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError
import com.talhafaki.domain.entity.NetworkMovie

/**
 * Created by tfakioglu on 12.December.2021
 */
@Composable
fun NowPlayingScreen() {
    val viewModel = hiltViewModel<NowPlayingViewModel>()

    NextflixComposableTheme(darkTheme = true) {
        Column(Modifier.background(Color.DarkGray)) {
            NowPlayingList(movieList = viewModel.nowPlayingList().collectAsLazyPagingItems())
        }
    }
}

@Composable
fun NowPlayingList(movieList: LazyPagingItems<NetworkMovie>) {
    LazyColumn {
        items(movieList.itemCount) { index ->
            movieList[index]?.let {
                MovieItem(movie = it)
            }
        }

        movieList.apply {
            when {
                loadState.refresh is LoadState.Error -> {
                    val e = movieList.loadState.refresh as LoadState.Error
                    item {
                        SweetError(message = e.error.localizedMessage ?: "Error")
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = movieList.loadState.append as LoadState.Error
                    item {
                        SweetError(message = e.error.localizedMessage ?: "Error")
                    }
                }
            }
        }
    }
}
