package com.talhafaki.domain.usecase

import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class PopularUseCaseTest : AbstractUseCaseTest() {

    private lateinit var useCase: PopularUseCase

    @Before
    fun setUp() {
        useCase = PopularUseCase(netflixGateway)
    }

    @Test
    fun `verify getNowPlayingMovies`() = runTest {
        useCase.invoke(page)
        verify(netflixGateway).getPopularMovies(page)
    }

    @Test
    fun getPopularMovies() = runTest {
        whenever(useCase.invoke(page)).thenReturn(dummyResponse)
        val response = useCase.invoke(page)
        assertResponse(response)
    }
}