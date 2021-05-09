package com.example.movieapp.network.apihelper


import com.example.movieapp.API_KEY
import com.example.movieapp.network.apiservice.ApiService
import javax.inject.Inject

/**
 * Created by shande on 09-05-2021
 */
class ApiHelper @Inject constructor(private val apiService: ApiService) {

    suspend fun getPopularMovies() = apiService.getPopularMovies(API_KEY)

    suspend fun getUpcomingMovies() = apiService.getUpcomingMovies(API_KEY)

    suspend fun getMovieDetails(id: Int) = apiService.getMovie(id, API_KEY)

}