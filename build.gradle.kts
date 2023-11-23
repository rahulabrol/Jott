// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.diffplug.spotless") version "6.6.1"
    id("org.jetbrains.dokka") version "1.5.0"
    id("org.cqfn.diktat.diktat-gradle-plugin") version "1.0.3"
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("2.0.0-Beta1")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val androidGradle = com.rahul.jott.gradle.Library.Plugin.androidGradle
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

        val kotlin = com.rahul.jott.gradle.Library.Plugin.kotlin

        val navigationSafeArg = com.rahul.jott.gradle.Library.Plugin.navigationSafeArg

        val hilt = com.rahul.jott.gradle.Library.Plugin.hilt

        classpath(androidGradle)
        classpath(kotlin)
        classpath(navigationSafeArg)
        classpath(hilt)
        classpath(com.rahul.jott.gradle.Library.Plugin.googleGmsServices)
        classpath(com.rahul.jott.gradle.Library.Firebase.firebaseCrashlytics)
    }
}

val enableKover: Boolean = System.getProperty("enableKover", "false")?.toBoolean() ?: false

val koverEngine: String? = System.getProperty("koverEngine", null)

val koverReportOnCheck: Boolean? = System.getProperty("koverReportOnCheck", null)?.toBoolean()

val koverIntellijEngineVersion: String? = System.getProperty("koverIntellijEngineVersion", null)

val koverJacocoEngineVersion: String? = System.getProperty("koverJacocoEngineVersion", null)

val diktatDebug: Boolean = System.getProperty("diktatDebug", "false")?.toBoolean() ?: true

diktat {
    debug = diktatDebug
    inputs {
        include("**/*.kt")
        exclude(
            "**/src/androidTest/**",
            "**/src/test/**",
            "**/generated/source/apollo/**",
            "**/graphql/**"
        )
    }
}

kover {
    isDisabled = enableKover

    when (koverEngine) {
        "jacoco" -> coverageEngine.set(kotlinx.kover.api.CoverageEngine.JACOCO)
        "intellij" -> coverageEngine.set(kotlinx.kover.api.CoverageEngine.INTELLIJ)
        else -> if (!koverEngine.isNullOrEmpty()) {
            throw kotlin.Exception(
                "kover engine not supported $koverEngine"
            )
        }
    }

    koverReportOnCheck?.let {
        generateReportOnCheck = it
    }

    if (!koverJacocoEngineVersion.isNullOrEmpty()) {
        jacocoEngineVersion.set(koverJacocoEngineVersion)
    }

    if (!koverIntellijEngineVersion.isNullOrEmpty()) {
        intellijEngineVersion.set(koverIntellijEngineVersion)
    }
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude(
            "**/src/main/kotlin/com/priceline/gradle/**",
            "**/src/main/kotlin/com/priceline/android/negotiator/configuration/**",
            "**/car/src/main/kotlin/com/priceline/android/car/**",
            "**/src/main/kotlin/com/priceline/android/negotiator/device/profile/**",
            "**/src/test/java/com/priceline/android/negotiator/device/profile/**",
            "**/src/main/kotlin/com/priceline/android/hotel/**",
            "**/src/main/kotlin/com/priceline/android/hotel/data/**",
            "**/src/main/kotlin/com/priceline/android/flight/**",
            "**/src/main/kotlin/com/priceline/android/negotiator/logging/**",
            "**/src/main/kotlin/com/priceline/android/negotiator/NegotiatorApplication.kt",
            "**/src/test/kotlin/com/priceline/android/negotiator/flight/data/**",
            "**/src/test/kotlin/com/priceline/android/negotiator/car/data/**",
            "**/src/test/kotlin/com/priceline/android/negotiator/hotel/data/**"
        )
        trimTrailingWhitespace()
        ktlint(com.rahul.jott.gradle.Version.ktlint)
            .userData(
                mapOf(
                    "disabled_rules" to "no-wildcard-imports,no-unused-imports"
                )
            )
    }
    kotlinGradle {
        target("*.gradle.kts", "additionalScripts/*.gradle.kts")
        targetExclude(
            "build.gradle.kts",
        )
        trimTrailingWhitespace()
        ktlint(com.rahul.jott.gradle.Version.ktlint)
            .userData(
                mapOf(
                    "disabled_rules" to "no-wildcard-imports,no-unused-imports"
                )
            )
    }
}

allprojects {
    subprojects{
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
            kotlinOptions {
                jvmTarget = "1.8"

                //Need this in order to enable/opt-in the use of experimental kotlin feature such as : @OptIn(ExperimentalCoroutinesApi::class)
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-opt-in=kotlin.RequiresOptIn",
                    "-Xjvm-default=all-compatibility"
                )

                allWarningsAsErrors = true
            }
        }
    }

    subprojects{
        val coverageIncludes = listOf("com.priceline.android.*")

        val coverageExcludes = listOf(
            "*.BuildConfig",
            "*.*Application",
            "*.*Activity*",
            "*.*_*Factory*",
            "*.*_HiltModules*",
            "*.*TestTags",
            "*.compose.*",
            "*Worker*",
            "**.graphql.**",
            "**.type.**", // apollo generated classes
        )

        tasks.withType<kotlinx.kover.tasks.KoverXmlReportTask>().all {
            includes = coverageIncludes
            excludes = coverageExcludes
        }

        tasks.withType<kotlinx.kover.tasks.KoverHtmlReportTask>().all {
            includes = coverageIncludes
            excludes = coverageExcludes
        }
    }
}