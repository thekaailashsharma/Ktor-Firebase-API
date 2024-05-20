package com.example.models.getFireStore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name(
    @SerialName("stringValue")
    val stringValue: String?
)