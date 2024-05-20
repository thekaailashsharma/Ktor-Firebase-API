package com.example.models.addFirestore


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FieldsX(
    @SerialName("email")
    val email: EmailX?,
    @SerialName("name")
    val name: NameX?,
    @SerialName("pass")
    val pass: PassX?
)