package com.germanofilho.app.feature.movielist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.germanofilho.app.data.model.movielist.Movie
import com.germanofilho.app.feature.movielist.repository.MovieListRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MovieListViewModel(private val repository: MovieListRepository) : ViewModel(){

//    private val repository : MovieListRepository =  MovieListRepository(ApiFactory.tmdbApi)

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)


    val popularMoviesLiveData = MutableLiveData<MutableList<Movie>>()

    fun fetchMovies(){
        scope.launch {
                repository.getPopularMovies().let {
                popularMoviesLiveData.postValue(it)
            }
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}
