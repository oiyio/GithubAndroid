package com.omeriyioz.github_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GithubAndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: GithubAndroidApp
    }
}
