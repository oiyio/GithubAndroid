package com.omeriyioz.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.omeriyioz.data.database.models.UserDetail

@Dao
interface GithubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserDetailToDb(userDetail: UserDetail)

    @Query("SELECT * FROM table_userdetail")
    fun getAllUserDetails(): LiveData<List<UserDetail>>

    @Query("SELECT * FROM table_userdetail WHERE id = :id")
    suspend fun getUserDetailById(id: Int): UserDetail

    @Delete
    suspend fun deleteUserDetail(userDetail: UserDetail)
}
