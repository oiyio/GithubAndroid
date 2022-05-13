package com.omeriyioz.data.database

import androidx.room.TypeConverter
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.omeriyioz.data.database.models.Repo

class ListConverter {

    val objectMapper = jacksonObjectMapper()

    @TypeConverter
    fun fromStringToRepoList(json: String?): List<Repo>? {
        var winnerList: List<Repo>? = null
        try {
            winnerList = objectMapper.readValue(
                json,
                object : TypeReference<List<Repo>>() {}
            )
        } catch (ex: Exception) {
            // result += "\n\n---------Exception in converting json to User4 : $ex \n---------"
            winnerList = emptyList()
        }
        return winnerList
    }

    @TypeConverter
    fun fromListToString(list: List<Repo>?): String {
        return objectMapper.writeValueAsString(list)
    }
}