package com.example.plugins

import com.example.apiService.ApiService
import com.example.models.SignUpFirebaseAuth
import com.example.models.SignUpFirebaseResponse
import com.example.models.UserRegistrationRequest
import com.example.models.UserRegistrationResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.java.KoinJavaComponent.inject
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val apiKey = System.getenv("apiKey") ?: ""
    val service by inject<ApiService>()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/signUpFirebase") {
            val request = call.receive<UserRegistrationRequest>()
            val response = service.signUpFirebase(request)
            if (response.second != HttpStatusCode.OK) {
                call.respond(status = response.second, UserRegistrationResponse(success = false,
                    message = "Either User already exists or some error occurred"))
            } else {
                call.respond(status = response.second, response.first)
            }
        }
    }
}
