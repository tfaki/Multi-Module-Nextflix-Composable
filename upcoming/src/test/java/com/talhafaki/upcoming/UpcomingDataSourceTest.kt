package com.talhafaki.upcoming

import androidx.paging.PagingSource
import com.talhafaki.data.test.util.DataPlaceholder
import com.talhafaki.domain.usecase.UpcomingUseCase
import com.talhafaki.upcoming.data.UpcomingDataSource
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

class UpcomingDataSourceTest {
    private val movies = DataPlaceholder.movies
    private val response = Response.success(movies)
    private val responseEmpty = Response.success(movies.copy(results = emptyList()))

    private val upcomingUseCase: UpcomingUseCase = mock()
    private lateinit var nowPlayingDataSource: UpcomingDataSource

    @Before
    fun setUp() {
        nowPlayingDataSource = UpcomingDataSource(upcomingUseCase)
    }

    @Test
    fun loadRefresh_returnSuccess() = runTest {
        whenever(upcomingUseCase.invoke(1)).thenReturn(response)

        val loadResult = nowPlayingDataSource.load(PagingSource.LoadParams.Refresh(null, 20, false))
        val loadResultPage = loadResult as PagingSource.LoadResult.Page

        assertThat(
            loadResultPage,
            `is`(
                PagingSource.LoadResult.Page(
                    data = movies.results,
                    prevKey = null,
                    nextKey = 2
                )
            )
        )
    }

    @Test
    fun loadRefresh_returnError() = runTest {
        whenever(upcomingUseCase.invoke(1)).thenReturn(responseEmpty)

        val loadResult = nowPlayingDataSource.load(PagingSource.LoadParams.Refresh(null, 20, false))
        assertThat(
            loadResult is PagingSource.LoadResult.Error,
            `is`(true)
        )
    }
}