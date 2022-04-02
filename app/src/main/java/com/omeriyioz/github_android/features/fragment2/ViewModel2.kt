package com.omeriyioz.github_android.features.fragment2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omeriyioz.data.network.GithubRepository
import com.omeriyioz.data.network.models.UserDetailResponseDTO
import com.omeriyioz.data.network.models.UserResponseDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel2 @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val _userResponseDTO = MutableLiveData<UserResponseDTO>()
    val userResponseDTO: LiveData<UserResponseDTO>
        get() = _userResponseDTO

    private val _userDetailResponseDTO = MutableLiveData<UserDetailResponseDTO>()
    val userDetailResponseDTO: LiveData<UserDetailResponseDTO>
        get() = _userDetailResponseDTO

    fun searchUsers(username: String) {

        viewModelScope.launch {
            try {
                _userResponseDTO.value = repository.searchUsers(username)
                Log.d("omertest", "size :" + _userResponseDTO.value!!.total_count)
            } catch (exception: Exception) {
                Log.d("omertest", "searchUsers - exception ${exception.message}")
            }
        }

        viewModelScope.launch {
            try {
                _userDetailResponseDTO.value = repository.getUserDetail(username)
                Log.d("omertest", "size :" + _userDetailResponseDTO.value!!.avatar_url)
            } catch (exception: Exception) {
                Log.d("omertest", "searchUsers - exception ${exception.message}")
            }
        }
    }
}
