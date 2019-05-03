package com.germanofilho.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TopMovies : Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@TopMovies)
            // moduless
            //modules(myModule)
        }
    }
}