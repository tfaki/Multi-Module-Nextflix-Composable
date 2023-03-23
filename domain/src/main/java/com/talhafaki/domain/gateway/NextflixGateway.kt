package com.talhafaki.domain.gateway

import com.talhafaki.domain.entity.Movies
import retrofit2.Response

/**
 * Created by tfakioglu on 13.December.2021
 */
interface NextflixGateway {
    suspend fun getPopularMovies(page: Int): Response<Movies>
    suspend fun getNowPlayingMovies(page: Int): Response<Movies>
    suspend fun getUpcomingMovies(page: Int): Response<Movies>
}