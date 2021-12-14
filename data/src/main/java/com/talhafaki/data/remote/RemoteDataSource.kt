package com.talhafaki.data.remote

import com.talhafaki.domain.entity.Movies
import javax.inject.Inject

/**
 * Created by tfakioglu on 14.December.2021
 */
class RemoteDataSource @Inject constructor(
    private val nextflixService: NextflixService
) {

    suspend fun getPopularMovies(page: Int): Movies {
        return nextflixService.getPopular(page = page).asMovies()
    }

    suspend fun getNowPlaying(page: Int): Movies {
        return nextflixService.getNowPlaying(page = page).asMovies()
    }

    suspend fun getUpcoming(page: Int): Movies {
        return nextflixService.getUpcoming(page = page).asMovies()
    }

}