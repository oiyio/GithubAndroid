package com.omeriyioz.data.database

import androidx.lifecycle.LiveData
import com.omeriyioz.data.database.models.UserDetail
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val githubDao: GithubDao
) {

    fun getAllUserDetails(): LiveData<List<UserDetail>> = githubDao.getAllUserDetails()

    suspend fun getUserDetailById(id: Int): UserDetail {
        return githubDao.getUserDetailById(id)
    }

    suspend fun insertUserDetailToDb(userDetail: UserDetail) {
        githubDao.insertUserDetailToDb(userDetail)
    }

    suspend fun deleteUserDetail(userDetail: UserDetail) {
        githubDao.deleteUserDetail(userDetail)
    }
}
