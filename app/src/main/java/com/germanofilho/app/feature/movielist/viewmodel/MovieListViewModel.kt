package com.germanofilho.app.feature.movielist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.germanofilho.app.core.helper.Resource
import com.germanofilho.app.core.viewmodel.BaseViewModel
import com.germanofilho.app.data.model.movielist.Movie
import com.germanofilho.app.feature.movielist.repository.MovieListRepository
import kotlinx.coroutines.launch

class MovieListViewModel(private val repository: MovieListRepository) : BaseViewModel(){

    val popularMoviesLiveData = MutableLiveData<Resource<MutableList<Movie>>>()

    fun fetchMovies(){
        viewModelScope.launch {
            popularMoviesLiveData.loading(true)
            try {
                popularMoviesLiveData.success(repository.getPopularMovies().let { it })
            } catch (e: Exception) {
                popularMoviesLiveData.error(e)
            } finally {
                popularMoviesLiveData.loading(false)
            }
        }
    }
}
