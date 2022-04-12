package com.omeriyioz.data.database.models

import com.omeriyioz.data.network.models.RepoDTO

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "table_repo_search")
data class RepoSearch(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "repoList")
    val repoList: List<Repo>
) : Parcelable

@Parcelize
data class Repo(
    @ColumnInfo(name = "repo_id")
    val repo_id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "stargazers_count")
    val stars: Int?,
    @ColumnInfo(name = "open_issues_count")
    val issueCount: Int?,
) : Parcelable