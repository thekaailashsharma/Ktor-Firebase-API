package com.example.plugins

import com.example.apiService.ApiService
import com.example.models.UserLoginRequest
import com.example.models.UserRegistrationRequest
import com.example.models.UserRegistrationResponse
import com.example.models.addFirestore.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val apiKey = System.getenv("apiKey") ?: throw Exception("apiKey Not Found")
    val projectId = System.getenv("projectId") ?: throw Exception("projectId Not Found")
    val service by inject<ApiService>()
    routing {

        swaggerUI(path = "/swagger", swaggerFile = "openapi/documentation.yaml")

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

        get("/signInFirebase") {
            val parameters = call.parameters
            parameters["email"]?.let { email ->
                parameters["password"]?.let { password ->
                    val request = UserLoginRequest(email = email, password = password)
                    val response = service.signInFirebase(request)
                    if (response.second == HttpStatusCode.OK) {
                        val addFireStoreRequest = service.getDocumentFirebase(
                            request = request,
                            token = response.first.idToken
                        )
                        if (addFireStoreRequest.second == HttpStatusCode.OK) {
                            call.respond(addFireStoreRequest.second, UserRegistrationResponse(
                                success = true,
                                message = "User LoggedIn Successfully"
                            ))
                        } else {
                            call.respond(
                                status = addFireStoreRequest.second, UserRegistrationResponse(
                                    success = false,
                                    message = "Either User does not exists or some error occurred"
                                )
                            )
                        }
                    } else {
                        call.respond(
                            status = response.second, UserRegistrationResponse(
                                success = false,
                                message = "Either User does not exists or some error occurred"
                            )
                        )
                    }
                }

                call.respond(
                    status = HttpStatusCode.BadRequest, UserRegistrationResponse(
                        success = false,
                        message = "Pass Password as parameter"
                    )
                )
            }
            call.respond(
                status = HttpStatusCode.BadRequest, UserRegistrationResponse(
                    success = false,
                    message = "Pass Username or Password as parameters"
                )
            )
        }

        get("/userProfile") {
            val parameters = call.parameters
            parameters["email"]?.let { email ->
                parameters["password"]?.let { password ->
                    val request = UserLoginRequest(email = email, password = password)
                    val response = service.signInFirebase(request)
                    if (response.second == HttpStatusCode.OK) {
                        val addFireStoreRequest = service.getDocumentFirebase(
                            request = request,
                            token = response.first.idToken
                        )
                        if (addFireStoreRequest.second == HttpStatusCode.OK) {
                            call.respond(addFireStoreRequest.second, addFireStoreRequest.first)
                        } else {
                            call.respond(
                                status = addFireStoreRequest.second, UserRegistrationResponse(
                                    success = false,
                                    message = "Either User does not exists or some error occurred"
                                )
                            )
                        }
                    } else {
                        call.respond(
                            status = response.second, UserRegistrationResponse(
                                success = false,
                                message = "Either User does not exists or some error occurred"
                            )
                        )
                    }
                }

                call.respond(
                    status = HttpStatusCode.BadRequest, UserRegistrationResponse(
                        success = false,
                        message = "Pass Password as parameter"
                    )
                )
            }
            call.respond(
                status = HttpStatusCode.BadRequest, UserRegistrationResponse(
                    success = false,
                    message = "Pass Username or Password as parameters"
                )
            )
        }

        post("/updateUser") {
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
