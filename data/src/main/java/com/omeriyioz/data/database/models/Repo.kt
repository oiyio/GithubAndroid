package com.omeriyioz.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_repo")
data class Repo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "repo_id")
    val repo_id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "stargazers_count")
    val stars: Int?,
    @ColumnInfo(name = "open_issues_count")
    val issueCount: Int?,
)