package com.germanofilho.app.data.model.movielist

import com.google.gson.annotations.SerializedName

data class Movie(var name : String,
                 var id : Int,
                 var description : String,
                 @SerializedName("poster_path") var posterPath : String,
                 @SerializedName("backdrop_path")var backDropPath : String,
                 var adult : Boolean)

data class PopularMovieResponse(var results: List<Movie>)