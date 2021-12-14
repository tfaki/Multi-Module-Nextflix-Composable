package com.talhafaki.data.remote

import com.talhafaki.data.remote.response.Movie
import com.talhafaki.data.remote.response.MoviesResponse
import com.talhafaki.domain.entity.*

/**
 * Created by tfakioglu on 14.December.2021
 */
fun MoviesResponse.asMovies() = Movies(
    results = results.map { it.asMovie() },
    currentPage = 1,
    totalPages = totalPages,
)

fun Movie.asMovie() = NetworkMovie(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    voteAverage = voteAverage,
)