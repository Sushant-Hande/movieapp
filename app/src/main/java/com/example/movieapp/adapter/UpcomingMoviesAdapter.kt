package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieapp.R
import com.example.movieapp.databinding.UpcomingItemBinding
import com.example.movieapp.model.Movie

class UpcomingMoviesAdapter(
    private var upcomingMovieList: List<Movie>,
    private val imageWidth: Int,
    private val onMovieClick: (Movie) -> Unit
) :
    RecyclerView.Adapter<UpcomingMoviesAdapter.UpcomingMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: UpcomingItemBinding =
            UpcomingItemBinding.inflate(layoutInflater, parent, false)
        return UpcomingMovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UpcomingMovieViewHolder, position: Int) {
        holder.bind(upcomingMovieList[position], imageWidth, onMovieClick)
    }

    override fun getItemCount(): Int {
        return upcomingMovieList.size
    }


    fun addUpcomingMovies(popularMovieList: List<Movie>) {
        this.upcomingMovieList = popularMovieList
        notifyDataSetChanged()
    }

    inner class UpcomingMovieViewHolder(private val itemBinding: UpcomingItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(movie: Movie, imageWidth: Int, onMovieClick: (Movie) -> Unit) {
            with(itemBinding) {
                upcomingParent.layoutParams.width = imageWidth
                upcomingParent.setOnClickListener {
                    onMovieClick(movie)
                }
                ivImage.load(movie.getImagePath()) {
                    placeholder(R.drawable.ic_placeholder)
                }
            }
        }
    }

}
