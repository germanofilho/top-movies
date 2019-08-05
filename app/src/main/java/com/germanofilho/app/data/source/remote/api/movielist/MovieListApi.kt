package com.germanofilho.app.data.source.remote.api.movielist

import com.germanofilho.app.data.model.movielist.PopularMovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface MovieListApi {

    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<PopularMovieResponse>>

}
