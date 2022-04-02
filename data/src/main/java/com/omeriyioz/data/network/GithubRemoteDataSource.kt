package com.omeriyioz.data.network

import com.omeriyioz.data.network.models.RepoDTO
import com.omeriyioz.data.network.models.User
import com.omeriyioz.data.network.models.UserDetailResponseDTO
import com.omeriyioz.data.network.models.UserResponseDTO

class GithubRemoteDataSource @javax.inject.Inject constructor(
    private val retrofitService: GithubApiService
) {

    suspend fun getRepoDTOList(user: String): List<RepoDTO> {
        return retrofitService.getRepoDTOList(user)
    }

    suspend fun searchUsers(query: String): UserResponseDTO {
        return retrofitService.searchUsers(query)
    }

    suspend fun getUserDetail(username: String): UserDetailResponseDTO {
        return retrofitService.getUserDetail(username)
    }

    suspend fun getFollowers(username: String): List<User> {
        return retrofitService.getFollowers(username)
    }

    suspend fun getFollowing(username: String): List<User> {
        return retrofitService.getFollowing(username)
    }
}