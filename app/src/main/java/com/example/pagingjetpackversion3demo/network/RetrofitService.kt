package com.example.pagingjetpackversion3demo.network

import com.example.pagingjetpackversion3demo.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("popular")
    suspend fun getMoviePopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Movie
}