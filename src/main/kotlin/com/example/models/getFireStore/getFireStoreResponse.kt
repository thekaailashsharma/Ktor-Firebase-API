package com.example.models.getFireStore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class getFireStoreResponse(
    @SerialName("createTime")
    val createTime: String?,
    @SerialName("fields")
    val fields: Fields?,
    @SerialName("name")
    val name: String?,
    @SerialName("updateTime")
    val updateTime: String?
)