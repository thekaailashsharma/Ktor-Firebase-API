package com.example.models.addFirestore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fields(
    @SerialName("email")
    val email: Email?,
    @SerialName("name")
    val name: Name?,
    @SerialName("pass")
    val pass: Pass?
)