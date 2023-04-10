package com.talhafaki.popular.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.talhafaki.common.items.GridItem
import com.talhafaki.common.loading.ShimmerAnimation
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError
import com.talhafaki.domain.entity.NetworkMovie

/**
 * Created by tfakioglu on 12.December.2021
 */

@Composable
fun PopularRoute(viewModel: PopularViewModel = hiltViewModel()) {
    val popularList = viewModel.popularList.collectAsLazyPagingItems()

    PopularScreen(movieList = popularList)
}

@Composable
internal fun PopularScreen(movieList: LazyPagingItems<NetworkMovie>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.background(color = Color.DarkGray),
        content = {
            items(movieList.itemCount) { index ->
                movieList[index]?.let { movie ->
                    GridItem(
                        posterPath = movie.posterUrl,
                        title = movie.title,
                        desc = movie.overview,
                        rating = movie.rating
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
                    repeat((0..20).count()) {
                        item {
                            Box(
                                modifier = Modifier
                                    .background(color = Color.DarkGray)
                            ) {
                                ShimmerAnimation(isRowShimmer = false)
                            }
                        }
                    }
                }

                if (error != null) {
                    //TODO: add error handler
                    item { SweetError(message = error.error.localizedMessage ?: "Error") }
                }
            }
        }
    )
}
