rootProject.name = "api"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include("core", "identity-access", "task-management")
