package com.talhafaki.data.remote

import com.talhafaki.data.remote.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by tfakioglu on 12.December.2021
 */
interface NextflixService {

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int
    ): Response<MoviesResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int
    ): Response<MoviesResponse>

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("page") page: Int
    ): Response<MoviesResponse>

}
