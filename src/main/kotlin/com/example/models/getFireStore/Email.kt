package com.example.models.getFireStore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Email(
    @SerialName("stringValue")
    val stringValue: String?
)