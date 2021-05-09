package com.example.movieapp.movie_details

import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import coil.load
import com.example.movieapp.BaseActivity
import com.example.movieapp.POSTER_BASE_URL
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieDetailsActivityBinding
import com.example.movieapp.model.Movie
import com.example.movieapp.network.Status
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by shande on 09-05-2021
 */
@AndroidEntryPoint
class MovieDetailsActivity : BaseActivity() {
    lateinit var binding: MovieDetailsActivityBinding
    private val viewModel: MovieDetailsViewModel by viewModels()
    lateinit var movie: Movie

    override fun initializeViewBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.movie_details_activity)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        intent?.let { intent ->
            intent.getParcelableExtra<Movie>(MOVIE)?.let {
                movie = it
            }
        }
    }

    override fun observeViewModel() {
        if (::movie.isInitialized) {
            viewModel.getMovieDetails(movie.id).observe(this) {
                it.let { resource ->
                    when (resource.status) {

                        Status.Success -> {
                            resource.data?.let { movieDetail ->
                                with(binding) {
                                    tvOverView.text = movieDetail.overview
                                    ivPoster.load(POSTER_BASE_URL.plus(movieDetail.poster_path))
                                    tvTitle.text = movieDetail.title
                                    tvRelease.text = getString(R.string.r).plus(" | ")
                                        .plus(movieDetail.release_date)
                                    tvVotes.text = getString(R.string.votes).plus(": ").plus(movieDetail.vote_count).plus(" (Users)")
                                }
                            }
                        }

                        Status.Error -> {
                            Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                        }

                        Status.Loading -> {
                        }
                    }
                }

            }
        }
    }

    companion object {
        const val MOVIE = "movie"
    }

}