package com.omeriyioz.github_android.features.fragment3

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omeriyioz.data.network.GithubRepository
import com.omeriyioz.data.network.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel3 @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val _followerList = MutableLiveData<List<User>>()
    val followerList: LiveData<List<User>>
        get() = _followerList

    private val _followingList = MutableLiveData<List<User>>()
    val followingList: LiveData<List<User>>
        get() = _followingList

    fun getFollows(username: String) {
        viewModelScope.launch {
            try {
                _followerList.value = repository.getFollowers(username = username)
                Log.d("omertest", "size :" + _followingList.value!!.size.toString())
            } catch (exception: Exception) {
                Log.d("omertest", "getFollowers - exception ${exception.message}")
            }
        }

        viewModelScope.launch {
            try {
                _followingList.value = repository.getFollowing(username = username)
                Log.d("omertest", "size :" + _followingList.value!!.size.toString())
            } catch (exception: Exception) {
                Log.d("omertest", "getFollowing - exception ${exception.message}")
            }
        }
    }
}
