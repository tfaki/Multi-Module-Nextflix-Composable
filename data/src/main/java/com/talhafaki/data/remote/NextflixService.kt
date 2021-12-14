package com.talhafaki.data.remote

import com.talhafaki.data.remote.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by tfakioglu on 12.December.2021
 */
interface NextflixService {

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int
    ): MoviesResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int
    ): MoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int
    ): MoviesResponse

    companion object {
        const val API_KEY = ""
    }
}
