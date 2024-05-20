package com.example.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInFirebaseResponse(
    @SerialName("displayName")
    val displayName: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("expiresIn")
    val expiresIn: String?,
    @SerialName("idToken")
    val idToken: String?,
    @SerialName("kind")
    val kind: String?,
    @SerialName("localId")
    val localId: String?,
    @SerialName("refreshToken")
    val refreshToken: String?,
    @SerialName("registered")
    val registered: Boolean?
)