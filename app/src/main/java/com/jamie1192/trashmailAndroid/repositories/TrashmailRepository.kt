package com.jamie1192.trashmailAndroid.repositories

import com.jamie1192.trashmailAndroid.api.TrashmailAPI
import com.jamie1192.trashmailAndroid.api.models.QuickDisposableBody
import com.jamie1192.trashmailAndroid.di.App
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.get
import timber.log.Timber

class TrashmailRepository {

    private val apiService : TrashmailAPI = App().get()

    private val compDisposable = CompositeDisposable()

    fun test() {

        val body = QuickDisposableBody("asdqwe",
            "trashmail.com",
            "jastley92@gmail.com",
            10,
            7,
            0,
            true)

         val disposable : Disposable = apiService
             .quickDisposable("asdqwe2",
             "trashmail.com",
             "jastley92@gmail.com",
             10,
             7,
             0,
             true)
             .subscribeOn(Schedulers.io())
             .observeOn(Schedulers.io())
             .flatMap {
                 it.response()?.headers()?.toMultimap()?.get("Set-Cookie")?.forEach { cookie ->
                     Timber.i("Cookie: $cookie")
                     if(cookie.contains("trashmail_domain")) Timber.i("SUCCESS")
                 }
                 Timber.i("Cookie size: ${it.response()?.headers()?.toMultimap()?.get("Set-Cookie")?.size}")
             Observable.just(it.response()?.body())
             }
             .subscribe({
                 Timber.i("$it")
             }, {

             })
//


        compDisposable.add(disposable)

    }

}