package com.talhafaki.nextflixcomposable.ui.upcoming

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.talhafaki.data.remote.NextflixService
import com.talhafaki.data.remote.response.Movie
import com.talhafaki.domain.entity.NetworkMovie
import com.talhafaki.domain.usecase.UpcomingUseCase
import javax.inject.Inject

/**
 * Created by tfakioglu on 12.December.2021
 */
class UpcomingDataSource @Inject constructor(private val upcomingUseCase: UpcomingUseCase) :
    PagingSource<Int, NetworkMovie>() {
    override fun getRefreshKey(state: PagingState<Int, NetworkMovie>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NetworkMovie> {
        val nextPage = params.key ?: 1
        val movieResponse = upcomingUseCase(nextPage)
        return LoadResult.Page(
            data = movieResponse.results,
            prevKey =
            if (nextPage == 1) null
            else nextPage - 1,
            nextKey = nextPage.plus(1)
        )
    }
}
