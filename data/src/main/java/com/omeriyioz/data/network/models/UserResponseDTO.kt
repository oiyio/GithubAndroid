package com.omeriyioz.data.network.models

import com.google.gson.annotations.SerializedName

data class UserResponseDTO(
    val total_count: Int,
    @SerializedName("items")
    val items: List<User>
)

data class User(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatar_url: String
)
