package com.talhafaki.data.remote

import com.talhafaki.data.remote.response.MoviesResponse
import com.talhafaki.data.util.AssetsManager
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NextflixServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var nextflixService: NextflixService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        nextflixService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NextflixService::class.java)

        mockMoviesResponse()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun getPopular() = runTest {
        val response = nextflixService.getPopular(1)
        assertMoviesResponse(response.body())
    }

    @Test
    fun getNowPlaying() = runTest {
        val response = nextflixService.getNowPlaying(1)
        assertMoviesResponse(response.body())
    }

    @Test
    fun getUpcoming() = runTest {
        val response = nextflixService.getUpcoming(1)
        assertMoviesResponse(response.body())
    }

    private fun assertMoviesResponse(body: MoviesResponse?) {
        assertThat(body, notNullValue())
        assertThat(body?.results?.get(0)?.id, CoreMatchers.`is`(1))
        assertThat(body?.results?.get(0)?.originalTitle, CoreMatchers.`is`("Madame Web"))
    }

    private fun mockMoviesResponse() {
        AssetsManager.openStream("movies_response.json")?.use { stream ->
            mockWebServer.enqueue(
                MockResponse().apply {
                    setBody(String(stream.readBytes()))
                }
            )
        }
    }
}
