package com.example.apiService

import com.example.models.SignUpFirebaseAuth
import com.example.models.SignUpFirebaseResponse
import com.example.models.UserRegistrationRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.java.KoinJavaComponent.inject

class ApiService(private val client: HttpClient) {
    private val apiKey = System.getenv("apiKey") ?: ""
    suspend fun signUpFirebase(request: UserRegistrationRequest): Pair<SignUpFirebaseResponse, HttpStatusCode> {
        val signUpUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=$apiKey"
        val c = client.post {
            url(signUpUrl)
            setBody(
                SignUpFirebaseAuth(
                    email = request.email,
                    password = request.password,
                    returnSecureToken = true
                )
            )
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            headers {
                append("Accept", "*/*")
                append("Content-Type", "application/json")
            }
        }

        println("Token is ${c}")
        return Pair(c.body<SignUpFirebaseResponse>(), c.status)
    }

}