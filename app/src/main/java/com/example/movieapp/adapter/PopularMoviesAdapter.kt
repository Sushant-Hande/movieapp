package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieapp.R
import com.example.movieapp.databinding.PopularItemBinding
import com.example.movieapp.model.Movie

class PopularMoviesAdapter(private var popularMovieList: List<Movie>) :
    RecyclerView.Adapter<PopularMoviesAdapter.PopularMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: PopularItemBinding =
            PopularItemBinding.inflate(layoutInflater, parent, false)
        return PopularMovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        holder.bind(popularMovieList[position])
    }

    override fun getItemCount(): Int {
        return popularMovieList.size
    }


    fun addPopularMovies(popularMovieList: List<Movie>) {
        this.popularMovieList = popularMovieList
        notifyDataSetChanged()
    }

    class PopularMovieViewHolder(private val itemBinding: PopularItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(movie: Movie) {
            itemBinding.ivImage.load(movie.getImagePath()) {
                placeholder(R.drawable.ic_placeholder)
            }
            itemBinding.executePendingBindings()
        }
    }
}
