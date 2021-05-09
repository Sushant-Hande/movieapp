package com.example.movieapp.dashboard

import com.example.movieapp.network.apihelper.ApiHelper
import javax.inject.Inject

class DashboardRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getPopularMovies() = apiHelper.getPopularMovies()

    suspend fun getUpcomingMovies() = apiHelper.getUpcomingMovies()

}