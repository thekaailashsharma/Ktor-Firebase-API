package com.example.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpFirebaseAuth(
    @SerialName("email")
    val email: String?,
    @SerialName("password")
    val password: String?,
    @SerialName("returnSecureToken")
    val returnSecureToken: Boolean?
)