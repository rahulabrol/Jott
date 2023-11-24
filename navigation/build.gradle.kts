@file:Suppress("UNCHECKED_CAST")

import com.rahul.jott.gradle.Android
import com.rahul.jott.gradle.Library

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")

    id("kotlin-parcelize")
}
android {
    namespace = "com.rahul.jott.navigation"
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        resourceConfigurations += mutableSetOf(
            "en"
        )

        javaCompileOptions {
            annotationProcessorOptions {
                arguments + mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
        }
    }

    testOptions {
        unitTests {
            all {
                it.jvmArgs("-noverify")
            }

            tasks.withType<Test>().configureEach {
                maxParallelForks = (System.getenv("UNIT_TEST_MAX_PARALLEL_FORKS") ?: "16").toInt()
            }
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = com.rahul.jott.gradle.Version.composeCompiler
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lint {
        warningsAsErrors = true
        baseline = file("lint-baseline.xml")
    }
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    namespace = "com.priceline.android.navigation"

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        resourceConfigurations += mutableSetOf(
            "en"
        )

        javaCompileOptions {
            annotationProcessorOptions {
                arguments + mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
        }
    }

    testOptions {
        unitTests {
            all {
                it.jvmArgs("-noverify")
            }

            tasks.withType<Test>().configureEach {
                maxParallelForks = (System.getenv("UNIT_TEST_MAX_PARALLEL_FORKS") ?: "16").toInt()
            }
        }
    }


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = com.rahul.jott.gradle.Version.composeCompiler
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lint {
        warningsAsErrors = true
        baseline = file("lint-baseline.xml")
    }
}

dependencies {
    implementation(fileTree("include" to listOf("*.jar"), "dir" to "libs"))
    implementation(Library.Kotlin.kotlinStdlibJdk8)

    //Google material
    implementation(Library.Material.material)

    //Android X
    implementation(Library.Androidx.coreKtx)

    //Accompanist
    implementation(Library.Accompanist.navigation)
    implementation(Library.Accompanist.pager)
    implementation(Library.Accompanist.pagerIndicators)
    implementation(Library.Accompanist.systemUiController)

    //Navigation
    implementation(Library.Androidx.navigationCompose)
    implementation(Library.Androidx.hiltNavigationCompose)
    implementation(Library.Androidx.navigationUIKtx)

    //Jetpack Compose
    val composeBom = platform(Library.Compose.composeBillOfMaterials)
    implementation(composeBom)
    implementation(Library.Compose.compiler)
    implementation(Library.Compose.foundation)
    implementation(Library.Compose.foundationLayout)
    implementation(Library.Compose.material)
    implementation(Library.Compose.ui)
    implementation(Library.Compose.material)
}