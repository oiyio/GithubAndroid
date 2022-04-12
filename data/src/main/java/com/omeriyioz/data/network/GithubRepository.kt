package com.omeriyioz.data.network

import android.util.Log
import com.omeriyioz.data.database.LocalDataSource
import com.omeriyioz.data.database.models.RepoSearch
import com.omeriyioz.data.database.models.UserDetail
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

    suspend fun saveRepoSearch(username: String, value: List<RepoDTO>) {
        /*localDataSource.insertUserDetailToDb(
            UserDetail(login = "login", name = "omer", avatar_url = "url")
        )
*/
            // room'da liste saklamak mantık olarak yanlış gibi sanki orada hata veriyo
        /*
        * Cannot figure out how to save this field into database. You can consider adding a type converter for it.
    private final java.util.List<com.omeriyioz.data.database.models.Repo> repoList = null;
        https://stackoverflow.com/a/48260739/4633354 bi yolu varmış type converter kullanmayı dene.
        * */
        localDataSource.insertRepoSearchToDb(
            RepoSearch(
                username = "oiyio",
                repoList = emptyList()
            )
        )
    }

    suspend fun getRepoSearch() {
        val user = localDataSource.getUserDetailById(3)
        Log.d("omertest", "getRepoSearch: $user")
    }
}
