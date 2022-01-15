package com.talhafaki.data

import com.talhafaki.data.remote.RemoteDataSource
import com.talhafaki.domain.entity.Movies
import com.talhafaki.domain.gateway.NextflixGateway
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by tfakioglu on 13.December.2021
 */
class NextflixRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): NextflixGateway {

    override suspend fun getPopularMovies(page: Int): Response<Movies> {
        return remoteDataSource.getPopularMovies(page)
    }

    override suspend fun getNowPlayingMovies(page: Int): Response<Movies> {
        return remoteDataSource.getNowPlaying(page)
    }

    override suspend fun getUpcomingMovies(page: Int): Response<Movies> {
        return remoteDataSource.getUpcoming(page)
    }

}