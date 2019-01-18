package com.jamie1192.trashmailAndroid.api

import android.content.Context
import com.jamie1192.trashmailAndroid.BuildConfig
import com.jamie1192.trashmailAndroid.api.models.*
import com.jamie1192.trashmailAndroid.utils.NetworkInterceptor
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.Result
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

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

    @FormUrlEncoded
    @POST("/?lang=en")
    fun quickDisposable(@Field("form_source") source : String,
                    @Field("form_domain") domain : String,
                    @Field("form_dest") destEmail : String,
                    @Field("form_nb_redirections") redirCount : Int,
                    @Field("form_expire_days") expireDays : Int,
                    @Field("form_whitelisting") whitelisting : Int,
                    @Field("create_submit") createAccount : Boolean)
                    : Observable<Result<ResponseBody>> //TODO: maybe change
        //@Query("lang") lang : String,
//                        @Body quickDisposableBody : QuickDisposableBody



    companion object Factory {

        fun create(context : Context): TrashmailAPI {

            fun httpClient() = OkHttpClient.Builder().apply {
                addInterceptor(NetworkInterceptor(context))
                if (BuildConfig.DEBUG) addNetworkInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
            }.build()

            fun retrofit() = retrofit2.Retrofit.Builder().apply {
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://trashmail.com")
                client(httpClient())
            }.build().create(TrashmailAPI::class.java)

            return retrofit()
        }
    }

}