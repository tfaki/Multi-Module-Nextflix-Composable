package com.talhafaki.domain.util

/**
 * Created by tfakioglu on 13.December.2021
 */
object Constants {
    const val TMDB_BASE_URL = "https://api.themoviedb.org/3/"

    private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
    private const val IMAGE_SIZE_W185 = "w185"
    private const val IMAGE_SIZE_W780 = "w780"

    const val CAST_AVATAR_URL = IMAGE_BASE_URL + IMAGE_SIZE_W185
    const val CAST_IMDB_URL = "https://www.imdb.com/name/"
    const val POSTER_URL = IMAGE_BASE_URL + IMAGE_SIZE_W185
    const val BACKDROP_URL = IMAGE_BASE_URL + IMAGE_SIZE_W780
}