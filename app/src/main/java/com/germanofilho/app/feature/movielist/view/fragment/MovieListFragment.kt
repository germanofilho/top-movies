package com.germanofilho.app.feature.movielist.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.germanofilho.app.R
import com.germanofilho.app.core.view.ui.BaseFragment
import com.germanofilho.app.data.model.movielist.Movie
import com.germanofilho.app.feature.movielist.view.adapter.MovieAdapter
import com.germanofilho.app.feature.movielist.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : BaseFragment() {

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)


        movieListViewModel.fetchMovies()

        movieListViewModel.popularMoviesLiveData.observe(this, Observer {
            setupRecyclerView(it!!)
        })

    }

    private fun setupRecyclerView(movies : MutableList<Movie>){
        rv_movie_list.layoutManager = GridLayoutManager(context, 3)
        rv_movie_list.adapter = MovieAdapter(movies)
    }
}
