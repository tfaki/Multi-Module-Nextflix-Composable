package com.talhafaki.nowplaying.data

import androidx.paging.PagingSource
import com.talhafaki.data.test.util.DataPlaceholder
import com.talhafaki.domain.usecase.NowPlayingUseCase
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

class NowPlayingDataSourceTest {
    private val movies = DataPlaceholder.movies
    private val response = Response.success(movies)
    private val responseEmpty = Response.success(movies.copy(results = emptyList()))

    private val nowPlayingUseCase: NowPlayingUseCase = mock()
    private lateinit var nowPlayingDataSource: NowPlayingDataSource

    @Before
    fun setUp() {
        nowPlayingDataSource = NowPlayingDataSource(nowPlayingUseCase)
    }

    @Test
    fun loadRefresh_returnSuccess() = runTest {
        whenever(nowPlayingUseCase.invoke(1)).thenReturn(response)

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
        whenever(nowPlayingUseCase.invoke(1)).thenReturn(responseEmpty)

        val loadResult = nowPlayingDataSource.load(PagingSource.LoadParams.Refresh(null, 20, false))
        assertThat(
            loadResult is PagingSource.LoadResult.Error,
            `is`(true)
        )
    }
}