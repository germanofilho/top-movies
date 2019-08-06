package com.germanofilho.app.feature.movielist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.germanofilho.app.BuildConfig
import com.germanofilho.app.R
import com.germanofilho.app.data.model.movielist.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movies : List<Movie> = arrayListOf()) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.item_movie, p0, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
    fun bind(movie: Movie) = with(view){
        Glide.with(view)
            .load(BuildConfig.TMDB_IMAGE_API.plus(movie.posterPath))
            .centerCrop()
            .into(imgItem)
    }
}


