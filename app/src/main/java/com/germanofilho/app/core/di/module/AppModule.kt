package com.germanofilho.app.core.di.module

import com.germanofilho.app.feature.movielist.repository.MovieListRepository
import com.germanofilho.app.feature.movielist.viewmodel.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<MovieListRepository>{
        MovieListRepository()
    }

    viewModel<MovieListViewModel> {
        MovieListViewModel(get())
    }
}