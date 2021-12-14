package com.talhafaki.domain.gateway

import com.talhafaki.domain.entity.Movies
import kotlinx.coroutines.flow.Flow

/**
 * Created by tfakioglu on 13.December.2021
 */
interface NextflixGateway {
    suspend fun getPopularMovies(page: Int): Movies
    suspend fun getNowPlayingMovies(page: Int): Movies
    suspend fun getUpcomingMovies(page: Int): Movies
}