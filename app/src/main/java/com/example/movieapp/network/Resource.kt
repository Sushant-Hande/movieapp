package com.example.movieapp.network

/**
 * Created by shande on 09-05-2021
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.Success, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.Error, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.Loading, data, null)
        }

    }
}
