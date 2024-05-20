package com.example.models.addFirestore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassX(
    @SerialName("stringValue")
    val stringValue: String?
)