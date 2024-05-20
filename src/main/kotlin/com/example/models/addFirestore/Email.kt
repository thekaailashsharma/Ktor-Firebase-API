package com.example.models.addFirestore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Email(
    @SerialName("stringValue")
    val stringValue: String?
)