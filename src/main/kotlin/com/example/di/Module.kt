package com.example.di

import com.example.apiService.ApiService
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module

@OptIn(ExperimentalSerializationApi::class)
val httpClientModule = module {
    single {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(json = Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
            install(Logging)
            install(HttpTimeout) {
                requestTimeoutMillis = 1000000
            }
        }
        ApiService(client)
    }
}