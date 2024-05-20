package com.example

import com.example.di.httpClientModule
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>) {
    embeddedServer(
        Netty,
        port = 8085,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    install(Koin) {
        slf4jLogger()
        modules(httpClientModule)
    }
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
