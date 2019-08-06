package com.germanofilho.app

import android.app.Application
import com.germanofilho.app.core.di.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TopMovies : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@TopMovies)
            modules(appModule)
        }
    }
}