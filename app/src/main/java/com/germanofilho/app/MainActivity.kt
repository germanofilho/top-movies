package com.germanofilho.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.germanofilho.app.feature.movielist.view.fragment.MovieListFragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                  addMovieListFragment()
                    true
                }
                else -> true
            }
        }

        // Starting tab bottom bar selected the profile section
        bottom_navigation.selectedItemId = R.id.nav_home

        //Places the fixed label in the menu
        bottom_navigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
    }

    private fun setContentLayout(fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, fragment, tag).commit()
    }

    private fun addMovieListFragment(){
        val fragment = MovieListFragment()
        setContentLayout(fragment, "")
    }
}
