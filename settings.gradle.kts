pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Jott"

val includeAppTarget get() = (System.getenv("INCLUDE_APP_TARGET") ?: "false").toBoolean()

val moduleList = mutableListOf(
    ":app",
    ":dsm",
)
include(moduleList)
