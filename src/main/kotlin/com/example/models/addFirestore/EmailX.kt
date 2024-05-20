package com.example.models.addFirestore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmailX(
    @SerialName("stringValue")
    val stringValue: String?
)