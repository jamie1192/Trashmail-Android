package com.jamie1192.trashmailAndroid.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by jamie1192 on 27/11/18.
 */
@Entity(tableName = "disposables")
data class DisposableEntity(
    @PrimaryKey
    @ColumnInfo(name = "email")
    val email: String,
    val realEmail : String,
    val numberForwards : Int,
    val lifespan : Int
)
