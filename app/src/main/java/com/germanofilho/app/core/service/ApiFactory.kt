package com.germanofilho.app.core.service

import com.germanofilho.app.BuildConfig
import com.germanofilho.app.data.source.remote.api.movielist.MovieListApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory{

    private val authInterceptor = Interceptor {chain->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val tmdbClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val tmdbApi : MovieListApi = retrofit().create(MovieListApi::class.java)
}