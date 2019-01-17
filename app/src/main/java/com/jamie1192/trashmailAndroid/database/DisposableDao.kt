package com.jamie1192.trashmailAndroid.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by jamie1192 on 27/11/18.
 */
@Dao
interface DisposableDao {

    @Query("SELECT * FROM disposables")
    fun getAllDisposableEmails() : LiveData<List<DisposableEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDisposable(disposableEntity: DisposableEntity)



}