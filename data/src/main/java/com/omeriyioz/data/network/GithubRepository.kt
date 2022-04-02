package com.omeriyioz.data.network

import com.omeriyioz.data.database.LocalDataSource
import com.omeriyioz.data.network.models.RepoDTO
import com.omeriyioz.data.network.models.User
import com.omeriyioz.data.network.models.UserDetailResponseDTO
import com.omeriyioz.data.network.models.UserResponseDTO
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val githubRemoteDataSource: GithubRemoteDataSource
) {

    suspend fun getRepoDTOList(user: String): List<RepoDTO> {
        return githubRemoteDataSource.getRepoDTOList(user)
    }

    suspend fun searchUsers(query: String): UserResponseDTO {
        return githubRemoteDataSource.searchUsers(query)
    }

    suspend fun getUserDetail(username: String): UserDetailResponseDTO {
        return githubRemoteDataSource.getUserDetail(username)
    }

    suspend fun getFollowers(username: String): List<User> {
        return githubRemoteDataSource.getFollowers(username)
    }

    suspend fun getFollowing(username: String): List<User> {
        return githubRemoteDataSource.getFollowing(username)
    }
}
