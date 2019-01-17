package com.jamie1192.trashmailAndroid.utils

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class NetworkInterceptor(context : Context) : Interceptor {

    private val ctxt = context

    override fun intercept(chain: Interceptor.Chain): Response {

        if(!NetworkUtil.isOnline(ctxt)) {
            throw NoNetworkException()
        }

        fun builder() = Request.Builder().apply {
            chain.request().newBuilder()
        }

        return chain.proceed(builder().build())
    }

    object NetworkUtil {

        @JvmStatic
        fun isOnline(context : Context) : Boolean {
            val connectivityManager : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo

            return (networkInfo != null && networkInfo.isConnected)
        }
    }
}


class NoNetworkException : IOException() {
    override val message: String?
        get() = super.message
}