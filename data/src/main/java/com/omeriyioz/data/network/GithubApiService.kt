package com.omeriyioz.data.network

import com.omeriyioz.data.network.models.RepoDTO
import com.omeriyioz.data.network.models.User
import com.omeriyioz.data.network.models.UserDetailResponseDTO
import com.omeriyioz.data.network.models.UserResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    /* Repos of a user
    * 🔥 https://api.github.com/users/oiyio/repos
    * */
    @GET("users/{login}/repos")
    suspend fun getRepoDTOList(@Path("login") login: String): List<RepoDTO>

    /* Search users
    * 🔥 https://api.github.com/search/users?q=oiyio
    * */
    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): UserResponseDTO

    /* User detail
    * 🔥 https://api.github.com/users/oiyio
    * */
    @GET("users/{username}")
    suspend fun getUserDetail(@Path("username") username: String): UserDetailResponseDTO

    /* List of followers
    * 🔥 https://api.github.com/users/oiyio/followers
    * */
    @GET("users/{username}/followers")
    suspend fun getFollowers(@Path("username") username: String): List<User>

    /* List of following
    * 🔥 https://api.github.com/users/oiyio/following
    * */
    @GET("users/{username}/following")
    suspend fun getFollowing(@Path("username") username: String): List<User>
}
