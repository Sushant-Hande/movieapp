package com.example.movieapp.network.apiservice

import com.example.movieapp.model.MovieDetails
import com.example.movieapp.network.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by shande on 09-05-2021
 */
interface ApiService {

    @GET("popular")
    suspend fun getPopularMovies(@Query(API_KEY) apKey: String): ApiResponse

    @GET("upcoming")
    suspend fun getUpcomingMovies(@Query(API_KEY) apKey: String): ApiResponse

    @GET("top_rated")
    suspend fun getTopRatedMovies(@Query(API_KEY) apKey: String): ApiResponse

    @GET("{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") id: Int,
        @Query(API_KEY) apiKEy: String
    ): MovieDetails

    @GET("{movie_id}/reviews")
    fun getMovieReviews(
        @Path("movie_id") id: Int,
        @Query(API_KEY) apiKEy: String
    ): ApiResponse

    @GET("{movie_id}/videos")
    fun getMovieTrailers(
        @Path("movie_id") id: Int,
        @Query(API_KEY) apiKEy: String?
    ): ApiResponse

    companion object {
        const val API_KEY = "api_key"
        const val PAGE = "page"
    }
}
