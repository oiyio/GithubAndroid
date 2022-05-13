package com.omeriyioz.github_android.features.fragment1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omeriyioz.data.network.GithubRepository
import com.omeriyioz.data.network.models.RepoDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel1 @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val _repoDTOList = MutableLiveData<List<RepoDTO>>()
    val repoDTOList: LiveData<List<RepoDTO>>
        get() = _repoDTOList


    fun getRepoDTOList(username: String) {
        viewModelScope.launch {
            try {
                _repoDTOList.value = repository.getRepoDTOList(username)
                repository.saveRepoSearch(username, _repoDTOList.value!!)


                Log.d("omertest", "size3 :" + _repoDTOList.value!!.size.toString())
            } catch (e: Exception) {
                Log.d("omertest", "Exception : $e")
            }
        }
    }
}
