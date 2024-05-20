package com.example.apiService

import com.example.models.*
import com.example.models.addFirestore.AddFireStoreRequest
import com.example.models.addFirestore.FireStoreResponse
import com.example.models.getFireStore.getFireStoreResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
class ApiService(private val client: HttpClient) {
    private val apiKey = System.getenv("apiKey") ?: ""
    private val projectId = System.getenv("projectId") ?: ""
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

    suspend fun addDocumentFirebase(request: AddFireStoreRequest, token: String?): Pair<FireStoreResponse, HttpStatusCode> {
        val addFireStoreUrl = "https://firestore.googleapis.com/v1/projects/$projectId/" +
                "databases/(default)/documents/userInfo/${request.fields?.email?.stringValue}?updateMask.fieldPaths=name&" +
                "updateMask.fieldPaths=pass&updateMask.fieldPaths=email"
        val c = client.patch {
            url(addFireStoreUrl)
            setBody(
                request
            )
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            headers {
                append("Authorization", "Bearer $token")
                append("Accept", "*/*")
                append("Content-Type", "application/json")
            }
        }
        println("Response is ${c}")
        return Pair(c.body<FireStoreResponse>(), c.status)
    }

    suspend fun signInFirebase(request: UserLoginRequest): Pair<SignInFirebaseResponse, HttpStatusCode> {
        val signUpUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?" +
                "key=$apiKey"
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

        println("Login Token is ${c}")
        return Pair(c.body<SignInFirebaseResponse>(), c.status)
    }

    suspend fun getDocumentFirebase(request: UserLoginRequest, token: String?): Pair<getFireStoreResponse, HttpStatusCode> {
        val getFireStoreUrl = "https://firestore.googleapis.com/v1/projects/travvvy-f1b70/databases/(default)/" +
                "documents/userInfo/${request.email}"
        val c = client.get {
            url(getFireStoreUrl)
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            headers {
                append("Authorization", "Bearer $token")
                append("Accept", "*/*")
                append("Content-Type", "application/json")
            }
        }
        println("Get Document Response is ${c}")
        return Pair(c.body<getFireStoreResponse>(), c.status)
    }


}