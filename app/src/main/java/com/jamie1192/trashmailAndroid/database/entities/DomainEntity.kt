package com.jamie1192.trashmailAndroid.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "domainNames")
data class DomainEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val domainName : String,
    val email : String
)