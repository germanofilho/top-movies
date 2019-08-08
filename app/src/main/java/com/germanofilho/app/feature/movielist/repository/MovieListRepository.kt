package com.germanofilho.app.feature.movielist.repository

import com.germanofilho.app.core.repository.BaseRepository
import com.germanofilho.app.core.service.ApiFactory
import com.germanofilho.app.data.model.movielist.Movie

class MovieListRepository : BaseRepository() {

    suspend fun getPopularMovies() : MutableList<Movie>?{

        val movieResponse = safeApiCall(
            call = { ApiFactory.tmdbApi.getPopularMovie() },
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.results?.toMutableList()
    }

}