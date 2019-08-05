package com.germanofilho.app.feature.movielist.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.germanofilho.app.core.service.ApiFactory
import com.germanofilho.app.data.model.movielist.Movie
import com.germanofilho.app.feature.movielist.repository.MovieListRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MovieListViewModel : ViewModel(){

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : MovieListRepository = MovieListRepository(ApiFactory.tmdbApi)


    val popularMoviesLiveData = MutableLiveData<MutableList<Movie>>()

    fun fetchMovies(){
        scope.launch {
            val popularMovies = repository.getPopularMovies()
            popularMoviesLiveData.postValue(popularMovies)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}
