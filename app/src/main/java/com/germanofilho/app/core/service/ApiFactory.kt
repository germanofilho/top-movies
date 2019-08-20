package com.germanofilho.app.core.service

import com.germanofilho.app.BuildConfig
import com.germanofilho.app.data.source.remote.api.movielist.MovieListApi
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

    fun <API> request(api : Class<API>) : API{
        return Retrofit.Builder()
            .client(tmdbClient)
            .baseUrl(BuildConfig.TMDB_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}