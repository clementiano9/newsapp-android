package com.ctw.newsapp

import android.app.Application
import com.ctw.newsapp.di.appModules
import org.koin.core.context.startKoin

class NewsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}