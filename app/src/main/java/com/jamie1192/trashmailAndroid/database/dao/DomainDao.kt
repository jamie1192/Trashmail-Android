package com.jamie1192.trashmailAndroid.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jamie1192.trashmailAndroid.database.entities.DomainEntity
import io.reactivex.Observable

@Dao
interface DomainDao {

    @Query("SELECT * FROM domainNames")
    fun getAllDomainNames() : LiveData<List<DomainEntity>>

    @Query("SELECT * FROM domainNames WHERE email = :email")
    fun getDomainsForEmail(email : String) : Observable<List<DomainEntity>>

    @Insert
    fun insertDomain(domain : DomainEntity)

    @Insert
    fun insertDomainList(domainList : List<DomainEntity>)


}