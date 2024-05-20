package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class UserRegistrationResponse(
    val success: Boolean,
    val message: String
)