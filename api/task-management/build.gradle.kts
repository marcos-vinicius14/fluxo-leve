
plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("io.ktor.plugin")
}

dependencies {
    implementation(project(":core"))
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-openapi")
    implementation("io.ktor:ktor-server-host-common")
    implementation("io.ktor:ktor-server-status-pages")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("org.jetbrains.exposed:exposed-core:${project.properties["exposed_version"]}")
    implementation("org.jetbrains.exposed:exposed-jdbc:${project.properties["exposed_version"]}")
    implementation("com.h2database:h2:${project.properties["h2_version"]}")
    implementation("org.postgresql:postgresql:${project.properties["postgres_version"]}")
    implementation("io.ktor:ktor-server-netty")
    implementation("ch.qos.logback:logback-classic:${project.properties["logback_version"]}")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:${project.properties["kotlin_version"]}")
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}
