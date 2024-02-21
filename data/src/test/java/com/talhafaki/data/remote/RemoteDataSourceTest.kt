package com.talhafaki.data.remote

import com.talhafaki.domain.entity.Movies
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class RemoteDataSourceTest {

    private val page = 1

    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp() {
        remoteDataSource = RemoteDataSource(FakeNextflixService())
    }

    @Test
    fun getNowPlaying() = runTest {
        val movies = remoteDataSource.getNowPlaying(page).body()
        assertMovies(movies)
    }

    @Test
    fun getPopularMovies() = runTest {
        val movies = remoteDataSource.getPopularMovies(page).body()
        assertMovies(movies)
    }

    @Test
    fun getUpcoming() = runTest {
        val movies = remoteDataSource.getUpcoming(page).body()
        assertMovies(movies)
    }

    private fun assertMovies(movies: Movies?) = runTest {
        assertThat(movies, notNullValue())
        assertThat(movies?.currentPage, `is`(page))
        assertThat(movies?.results?.get(0)?.id, `is`(1))
        assertThat(movies?.results?.get(0)?.title, `is`("Madame Web"))
    }
}