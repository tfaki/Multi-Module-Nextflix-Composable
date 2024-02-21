package com.talhafaki.domain.usecase

import com.talhafaki.domain.entity.Movies
import com.talhafaki.domain.gateway.NextflixGateway
import com.talhafaki.domain.util.DataPlaceholder
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.mockito.Mock
import retrofit2.Response

abstract class AbstractUseCaseTest {

    protected val page = 1
    protected val dummyResponse = Response.success(DataPlaceholder.movies)

    @Mock
    protected lateinit var netflixGateway: NextflixGateway

    protected fun assertResponse(response: Response<Movies>) {
        assertThat(response.code(), `is`(dummyResponse.code()))
        assertThat(response.body(), notNullValue())
        assertThat(response.body(), `is`(DataPlaceholder.movies))
    }
}