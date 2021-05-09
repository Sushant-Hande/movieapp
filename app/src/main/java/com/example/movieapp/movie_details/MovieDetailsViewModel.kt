package com.example.movieapp.movie_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by shande on 09-05-2021
 */
@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val movieDetailsRepository: MovieDetailsRepository) :
    ViewModel() {

    fun getMovieDetails(id: Int) = liveData {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = movieDetailsRepository.getMovieDetails(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }

}