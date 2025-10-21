package com.fluxo

import com.fluxodia.core.infraestructure.DatabaseFactory
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDatabases()
}

fun Application.configureDatabases() {
    DatabaseFactory.init(environment.config)
}
