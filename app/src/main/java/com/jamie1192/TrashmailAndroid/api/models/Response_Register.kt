package com.jamie1192.TrashmailAndroid.api.models

import com.google.gson.annotations.SerializedName

/**
 * Created by jamie1192 on 27/11/18.
 */
data class Response_Register (
    @SerializedName("success")
    var isSuccess : Boolean?,
    @SerializedName("error_code")
    var errorCode : Int?

)