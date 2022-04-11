package com.omeriyioz.github_android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

    private val _searchedUsername = MutableLiveData<String>()
    val searchedUsername: LiveData<String>
        get() = _searchedUsername

    fun setSearchedUsername(str: String) {
        _searchedUsername.value = str
        Log.d("omertest", "setSearchedUsername: $str")
    }
}
