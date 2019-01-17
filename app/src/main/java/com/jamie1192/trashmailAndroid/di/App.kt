package com.jamie1192.trashmailAndroid.di

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.jamie1192.trashmailAndroid.BuildConfig
import com.jamie1192.trashmailAndroid.api.TrashmailAPI
import com.jamie1192.trashmailAndroid.database.AppDatabase
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import timber.log.Timber
import timber.log.Timber.plant

class App : Application() {

    private val appModule = module {
        single { TrashmailAPI.create(get())}
        single { AppDatabase.getDatabase(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) plant(Timber.DebugTree())

        AndroidThreeTen.init(this)
        startKoin(this, listOf(appModule))
    }
}