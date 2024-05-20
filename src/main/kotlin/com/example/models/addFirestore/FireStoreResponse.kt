package com.example.models.addFirestore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FireStoreResponse(
    @SerialName("createTime")
    val createTime: String?,
    @SerialName("fields")
    val fields: Fields?,
    @SerialName("name")
    val name: String?,
    @SerialName("updateTime")
    val updateTime: String?
)