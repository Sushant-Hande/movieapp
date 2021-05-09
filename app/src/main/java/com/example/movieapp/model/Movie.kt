package com.example.movieapp.model

import android.os.Parcel
import android.os.Parcelable
import com.example.movieapp.POSTER_BASE_URL

/**
 * Created by shande on 09-05-2021
 */
class Movie() : Parcelable{

    var id: Int = 0
    var popularity: Float = 0f
    private var vote_count: Int = 0
    private var poster_path: String = ""
    var adult: Boolean? = null
    var video: Boolean? = null
    private var backdrop_path: String = ""
    private var original_language: String = ""
    private var original_title: String = ""
    var title: String = ""
    private var vote_average: Float = 0f
    var overview: String = ""
    private var release_date: String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        popularity = parcel.readFloat()
        vote_count = parcel.readInt()
        poster_path = parcel.readString()?:""
        adult = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        video = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        backdrop_path = parcel.readString()?:""
        original_language = parcel.readString()?:""
        original_title = parcel.readString()?:""
        title = parcel.readString()?:""
        vote_average = parcel.readFloat()
        overview = parcel.readString()?:""
        release_date = parcel.readString()?:""
    }

    fun getImagePath() = POSTER_BASE_URL + poster_path

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeFloat(popularity)
        parcel.writeInt(vote_count)
        parcel.writeString(poster_path)
        parcel.writeValue(adult)
        parcel.writeValue(video)
        parcel.writeString(backdrop_path)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(title)
        parcel.writeFloat(vote_average)
        parcel.writeString(overview)
        parcel.writeString(release_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }

}