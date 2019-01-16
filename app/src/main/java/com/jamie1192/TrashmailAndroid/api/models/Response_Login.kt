package com.jamie1192.TrashmailAndroid.api.models

import com.google.gson.annotations.SerializedName

/**
 * Created by jamie1192 on 27/11/18.
 */
data class Response_LogIn (

    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("error_code")
    val errorCode: Int?,
    @SerializedName("msg")
    val msg: Msg?
)

data class Msg (
    @SerializedName("url")
    var url: String?,
    @SerializedName("real_email_list")
    val realEmailList: Boolean?,
    @SerializedName("domain_name_list")
    var domainNameList: List<String>,
    @SerializedName("session_id")
    var sessionId: String
)