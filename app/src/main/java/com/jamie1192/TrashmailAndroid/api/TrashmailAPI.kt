package com.jamie1192.TrashmailAndroid.api

import com.jamie1192.TrashmailAndroid.api.models.*
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by jamie1192 on 27/11/18.
 */
interface TrashmailAPI {

    @POST("/?api=1")
    fun logIn(@Query("cmd") cmd: String,
              @Query("lang") lang: String) : Observable<Response_LogIn>

    @POST("/?api=1")
    fun register(@Query("cmd") cmd: String,
                 @Query("lang") lang: String,
                 @Body registerUser : RegisterBody) : Observable<Response_Register>

    @POST("/api=1")
    fun quickDisposable(@Query("lang") lang : String,
                        @Body quickDisposableBody : QuickDisposableBody
                        ) : Observable<ResponseBody> //TODO: maybe change


    companion object Factory {
        fun create(): TrashmailAPI {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.trashmail.com")
                .build()

            return retrofit.create(TrashmailAPI::class.java)
        }
    }

}