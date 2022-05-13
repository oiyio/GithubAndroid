package com.omeriyioz.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.omeriyioz.data.database.models.Repo
import com.omeriyioz.data.database.models.RepoSearch
import com.omeriyioz.data.database.models.UserDetail

@Database(
    entities = [UserDetail::class, RepoSearch::class, Repo::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class GithubDatabase : RoomDatabase() {

    abstract val githubDao: GithubDao
}