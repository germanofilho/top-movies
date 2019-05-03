package com.germanofilho.app.data.source.remote.api.movielist

import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieListEndPoint {

    @GET("list")
    fun getMovies(@Query("api_key") apiKey: String, @Query("page") page : Int, @Query("endDate") endDate : String)
}
