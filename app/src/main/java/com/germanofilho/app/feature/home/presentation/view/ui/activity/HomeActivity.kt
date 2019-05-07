package com.germanofilho.app.feature.home.presentation.view.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.germanofilho.app.R
import com.germanofilho.app.core.view.ui.BaseActivity
import com.germanofilho.app.feature.movielist.view.fragment.MovieListFragment
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavigationViewItemSelectedListener())
        // Starting tab bottom bar selected the profile section
        bottom_navigation.selectedItemId = R.id.nav_movie_list
    }


    private fun onBottomNavigationViewItemSelectedListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_movie_list -> {
                    addMovieListFragment()
                    true
                }
                else -> true
            }
        }
    }

    private fun setContentLayout(fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.content,
            fragment,
            tag
        )

        fragmentTransaction
            .commit()
    }

    private fun addMovieListFragment(){
        var fragment = MovieListFragment()
        setContentLayout(fragment, "")
    }
}
