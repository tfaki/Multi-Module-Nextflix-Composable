package com.talhafaki.data.test.util

import com.talhafaki.domain.entity.Movies
import com.talhafaki.domain.entity.NetworkMovie

object DataPlaceholder {

    val networkMovies = listOf(
        NetworkMovie(id = 1, title = "Madame Web", overview = "Forced to confront revelations about her past, paramedic Cassandra Webb forges a relationship with three young women destined for powerful futures...if they can all survive a deadly present.", posterPath = "/rULWuutDcN5NvtiZi4FRPzRYWSh.jpg", voteAverage = 5.441)
    )

    val movies = Movies(
        results = networkMovies,
        currentPage = 1,
        totalPages = 1
    )
}