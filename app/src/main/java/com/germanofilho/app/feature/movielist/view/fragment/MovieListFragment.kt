package com.germanofilho.app.feature.movielist.view.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import com.germanofilho.app.R
import com.germanofilho.app.core.view.ui.BaseFragment
import com.germanofilho.app.data.model.movielist.Movie
import com.germanofilho.app.feature.movielist.view.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : BaseFragment() {

    private lateinit var adapter : MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(generateList())
    }

    private fun setupRecyclerView(movies : List<Movie>){
        rv_movie_list.layoutManager = GridLayoutManager(context, 3)
        rv_movie_list.adapter = MovieAdapter(movies)
    }

    private fun generateList() : List<Movie> {
        val list = arrayListOf<Movie>()

        for(i in 1..10){
            list.add(Movie("", 1, "",
                "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SY1000_CR0,0,665,1000_AL_.jpg",
                "", false))
        }
        return list
    }

}
