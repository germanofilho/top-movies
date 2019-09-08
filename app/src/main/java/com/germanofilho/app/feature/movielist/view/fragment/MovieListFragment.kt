package com.germanofilho.app.feature.movielist.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.germanofilho.app.R
import com.germanofilho.app.core.helper.observeResource
import com.germanofilho.app.core.view.ui.BaseFragment
import com.germanofilho.app.data.model.movielist.Movie
import com.germanofilho.app.feature.movielist.view.adapter.MovieAdapter
import com.germanofilho.app.feature.movielist.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment() {

    private val viewModel: MovieListViewModel by viewModel()
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMovies()
    }

    override fun onStart() {
        super.onStart()

        viewModel.popularMoviesLiveData.observeResource(this,
            onSuccess = {
                showSuccess()
                setupRecyclerView(it)
            },
            onLoading = {
                showLoading(it)
            },
            onError =  {
                showError()
            }
        )
    }
    private fun showLoading(b : Boolean){
        if(b) progress_bar.visibility = View.VISIBLE
        else progress_bar.visibility = View.GONE
    }

    private fun showSuccess(){
        rv_movie_list.visibility = View.VISIBLE
        txt_error.visibility = View.GONE
    }

    private fun showError(){
        rv_movie_list.visibility = View.GONE
        txt_error.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(movies : MutableList<Movie>){
        rv_movie_list.layoutManager = GridLayoutManager(context, 3)
        rv_movie_list.adapter = MovieAdapter(movies)
    }
}
