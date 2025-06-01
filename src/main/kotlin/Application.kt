package com.example

import com.example.presentation.config.configureRouting
import com.example.presentation.config.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

// entry point of ktor backend
fun Application.module() {
    configureRouting()
    configureSerialization()
}
