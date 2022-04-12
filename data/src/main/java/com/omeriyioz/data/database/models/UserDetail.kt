package com.omeriyioz.data.database.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "table_userdetail")
data class UserDetail(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "avatar_url")
    val avatar_url: String
) : Parcelable
