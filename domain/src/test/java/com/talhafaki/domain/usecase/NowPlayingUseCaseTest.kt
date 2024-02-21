package com.talhafaki.domain.usecase

import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class NowPlayingUseCaseTest : AbstractUseCaseTest() {

    private lateinit var useCase: NowPlayingUseCase

    @Before
    fun setUp() {
        useCase = NowPlayingUseCase(netflixGateway)
    }

    @Test
    fun `verify getNowPlayingMovies`() = runTest {
        useCase.invoke(page)
        verify(netflixGateway).getNowPlayingMovies(page)
    }

    @Test
    fun getNowPlayingMovies() = runTest {
        whenever(useCase.invoke(page)).thenReturn(dummyResponse)
        val response = useCase.invoke(page)
        assertResponse(response)
    }
}