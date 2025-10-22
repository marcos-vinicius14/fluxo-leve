// Declaração de versões para serem usadas no projeto
val exposed_version: String by project
val h2_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val postgres_version: String by project

plugins {
    kotlin("jvm") version "2.2.20"
    id("io.ktor.plugin") version "3.3.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.20"
}

group = "com.fluxo-leve"
version = "0.0.1"

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation("io.ktor:ktor-server-config-yaml:2.3.11")
        implementation("org.postgresql:postgresql:42.7.3")
        implementation("org.jetbrains.exposed:exposed-core:0.51.1")
        implementation("org.jetbrains.exposed:exposed-jdbc:0.51.1")
        implementation("io.ktor:ktor-server-core-jvm:2.3.11")
        implementation("io.ktor:ktor-server-netty-jvm:2.3.11")
    }
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.3.11")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.11")



    implementation(project(":core"))
    implementation("io.ktor:ktor-server-content-negotiation:3.3.0")
    implementation("io.ktor:ktor-server-core:3.3.0")
    implementation("io.ktor:ktor-server-core:3.3.0")
    implementation("io.ktor:ktor-server-core:3.3.0")
    implementation("io.ktor:ktor-server-host-common:3.3.0")
    implementation("io.ktor:ktor-server-status-pages:3.3.0")

    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.11")

    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.3.11")
}