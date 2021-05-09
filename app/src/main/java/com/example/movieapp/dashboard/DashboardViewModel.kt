package com.example.movieapp.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by shande on 09-05-2021
 */
@HiltViewModel
class DashboardViewModel @Inject constructor(private val dashboardRepositoryImpl: DashboardRepository) :
    ViewModel() {

    fun getPopularMovies() = liveData{
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = dashboardRepositoryImpl.getPopularMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

    fun getUpcomingMovies() = liveData{
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = dashboardRepositoryImpl.getUpcomingMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

}