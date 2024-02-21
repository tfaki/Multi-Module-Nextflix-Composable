package com.talhafaki.domain.usecase

import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class UpcomingUseCaseTest : AbstractUseCaseTest() {

    private lateinit var useCase: UpcomingUseCase

    @Before
    fun setUp() {
        useCase = UpcomingUseCase(netflixGateway)
    }

    @Test
    fun `verify getNowPlayingMovies`() = runTest {
        useCase.invoke(page)
        verify(netflixGateway).getUpcomingMovies(page)
    }

    @Test
    fun getUpcomingMovies() = runTest {
        whenever(useCase.invoke(page)).thenReturn(dummyResponse)
        val response = useCase.invoke(page)
        assertResponse(response)
    }
}