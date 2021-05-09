package com.example.movieapp.movie_details

import com.example.movieapp.network.apihelper.ApiHelper
import javax.inject.Inject

/**
 * Created by shande on 09-05-2021
 */
class MovieDetailsRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getMovieDetails(id: Int) = apiHelper.getMovieDetails(id)

}