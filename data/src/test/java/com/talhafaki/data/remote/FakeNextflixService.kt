package com.talhafaki.data.remote

import com.google.gson.Gson
import com.talhafaki.data.remote.response.MoviesResponse
import com.talhafaki.data.util.AssetsManager
import retrofit2.Response
import java.io.InputStreamReader

class FakeNextflixService : NextflixService {

    override suspend fun getPopular(page: Int): Response<MoviesResponse> {
        return Response.success(getMoviesResponse())
    }

    override suspend fun getNowPlaying(page: Int): Response<MoviesResponse> {
        return Response.success(getMoviesResponse())
    }

    override suspend fun getUpcoming(page: Int): Response<MoviesResponse> {
        return Response.success(getMoviesResponse())
    }

    private fun getMoviesResponse(): MoviesResponse? {
        return AssetsManager.openStream("movies_response.json")?.use { stream ->
            val gson = Gson()
            val reader = InputStreamReader(stream)
            gson.fromJson(reader, MoviesResponse::class.java)
        }
    }
}