package com.example.plugins

import com.example.apiService.ApiService
import com.example.models.UserRegistrationRequest
import com.example.models.UserRegistrationResponse
import com.example.models.addFirestore.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
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
            if (response.second == HttpStatusCode.OK) {
                val addFireStoreRequest = service.addDocumentFirebase(
                    request = AddFireStoreRequest(
                        fields = FieldsX(
                            email = EmailX(stringValue = request.email),
                            pass = PassX(stringValue = request.password),
                            name = NameX(stringValue = request.username)
                        )
                    ),
                    token = response.first.idToken
                )
                if (addFireStoreRequest.second == HttpStatusCode.OK) {
                    call.respond(addFireStoreRequest.second, addFireStoreRequest.first)
                } else {
                    call.respond(status = addFireStoreRequest.second, UserRegistrationResponse(success = false,
                        message = "Either User already exists or some error occurred"))
                }
            } else {
                call.respond(status = response.second, UserRegistrationResponse(success = false,
                    message = "Either User already exists or some error occurred"))
            }
        }
    }
}
