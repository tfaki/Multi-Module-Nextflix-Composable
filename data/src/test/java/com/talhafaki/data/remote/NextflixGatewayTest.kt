package com.talhafaki.data.remote

import com.talhafaki.data.NextflixRepository
import com.talhafaki.domain.entity.Movies
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class NextflixGatewayTest {

    private val page = 1

    private lateinit var nextflixRepository: NextflixRepository

    @Before
    fun setUp() {
        nextflixRepository = NextflixRepository(RemoteDataSource(FakeNextflixService()))
    }

    @Test
    fun getNowPlayingMovies() = runTest {
        val movies = nextflixRepository.getNowPlayingMovies(page).body()
        assertMovies(movies)
    }

    @Test
    fun getPopularMovies() = runTest {
        val movies = nextflixRepository.getPopularMovies(page).body()
        assertMovies(movies)
    }

    @Test
    fun getUpcomingMovies() = runTest {
        val movies = nextflixRepository.getUpcomingMovies(page).body()
        assertMovies(movies)
    }

    private fun assertMovies(movies: Movies?) = runTest {
        MatcherAssert.assertThat(movies, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(movies?.currentPage, CoreMatchers.`is`(page))
        MatcherAssert.assertThat(movies?.results?.get(0)?.id, CoreMatchers.`is`(1))
        MatcherAssert.assertThat(movies?.results?.get(0)?.title, CoreMatchers.`is`("Madame Web"))
    }
}