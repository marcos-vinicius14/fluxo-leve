package com.fluxodia

import com.fluxodia.infrastructure.configureDatabases
import com.fluxodia.infrastructure.configureHTTP
import com.fluxodia.infrastructure.configureRouting
import com.fluxodia.infrastructure.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureDatabases()
    configureRouting()
}
