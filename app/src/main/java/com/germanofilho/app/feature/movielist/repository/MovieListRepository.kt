package com.germanofilho.app.feature.movielist.repository

import com.germanofilho.app.core.repository.BaseRepository
import com.germanofilho.app.data.model.movielist.Movie
import com.germanofilho.app.data.source.remote.api.movielist.MovieListApi

class MovieListRepository(private val api : MovieListApi) : BaseRepository() {

    suspend fun getPopularMovies() : MutableList<Movie>?{

        val movieResponse = safeApiCall(
            call = {api.getPopularMovie().await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.results?.toMutableList()
    }

}