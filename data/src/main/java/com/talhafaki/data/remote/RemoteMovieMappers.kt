package com.talhafaki.data.remote

import com.talhafaki.data.remote.response.Movie
import com.talhafaki.data.remote.response.MoviesResponse
import com.talhafaki.domain.entity.*
import retrofit2.Response

/**
 * Created by tfakioglu on 14.December.2021
 */
fun Response<MoviesResponse>.asMovies(): Response<Movies> = Response.success(body()?.let {
    Movies(
        results = it.results.map { movies -> movies.asMovie() },
        currentPage = 1,
        totalPages = it.totalPages,
    )
})

fun Movie.asMovie() = NetworkMovie(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    voteAverage = voteAverage,
)