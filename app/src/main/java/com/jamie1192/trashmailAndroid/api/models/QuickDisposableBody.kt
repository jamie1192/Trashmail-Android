package com.jamie1192.trashmailAndroid.api.models

import com.google.gson.annotations.SerializedName

class QuickDisposableBody (
    @SerializedName("form_source")
    var formSource : String?,
    @SerializedName("form_domain")
    var formDomain : String?,
    @SerializedName("form_dest")
    var formDest : String?,
    @SerializedName("form_nb_redirections")
    var redirs : Int?,
    @SerializedName("form_expire_days")
    var expiry : Int?,
    @SerializedName("form_whitelisting")
    var isWhitelisted : Boolean?,
    @SerializedName("create_submit")
    var createAccount : Boolean?
)
