
plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation("org.flywaydb:flyway-core:10.5.0")
    implementation("org.flywaydb:flyway-database-postgresql:10.5.0")
    implementation("com.zaxxer:HikariCP:5.1.0")

    implementation("org.jetbrains.exposed:exposed-core:0.51.1")
    implementation("io.ktor:ktor-server-config-yaml:2.3.11")
}