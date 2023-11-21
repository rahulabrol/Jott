@file:Suppress("UNCHECKED_CAST", "UnstableApiUsage")

import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import com.rahul.jott.gradle.Android
import com.rahul.jott.gradle.Library
import java.io.FileInputStream
import java.util.*

plugins {
    kotlin("plugin.serialization") version com.rahul.jott.gradle.Version.kotlin
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
//    id("com.google.gms.google-services")
//    id("com.google.firebase.crashlytics")
}

hilt {
    enableAggregatingTask = true
}

apply(from = "compute.gradle.kts")

val localProperties = Properties()

if (file("${project.rootDir}/local.properties").exists()) {
    try {
        localProperties.load(FileInputStream(rootProject.file("local.properties")))
    } catch (e: Exception) {
        println(e.toString())
    }
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    namespace = "com.rahul.jott"

    defaultConfig {
        applicationId = "com.rahul.jott"
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = (extra["computeVersionCode"] as () -> Int)()
        versionName = (extra["computeVersionName"] as () -> String)()

        testApplicationId = "com.rahul.jott.android.negotiator.testing"
        testInstrumentationRunner = "com.rahul.jott.android.negotiator.CustomTestRunner"
        //testBuildType = System.getProperty("testBuildType", "debug")

        resourceConfigurations += mutableSetOf(
            "en"
        )

        ndk {
            abiFilters + setOf("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
        }


        javaCompileOptions {
            annotationProcessorOptions {
                arguments + mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true"
                )
            }
        }

        composeOptions {
            kotlinCompilerExtensionVersion = com.rahul.jott.gradle.Version.composeCompiler
        }

        buildFeatures {
            compose = true
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

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
//            ndk {
//                debugSymbolLevel = "FULL"
//            }
//
//            ext["enableCrashlytics"] = false
//            configure<CrashlyticsExtension> {
//                mappingFileUploadEnabled = false
//            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    /**
     * Packaging options added to resolve [DuplicateRelativeFileException]
     * when running instrumented UI tests.
     *
     * @see [kotlinx-coroutines-debug](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-debug/index.html)
     * Under the section [Debug agent and Android]
     */
    packagingOptions {
        resources.excludes.add("META-INF/*")
        resources.excludes.add("META-INF/licenses/ASM")
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
        resources.pickFirsts += "win32-x86-64/attach_hotspot_windows.dll"
        resources.pickFirsts += "win32-x86/attach_hotspot_windows.dll"
    }
}

dependencies {
//    implementation("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
    implementation(project(":dsm"))

    implementation(Library.Kotlin.kotlinxSerialization)
    implementation(Library.Kotlin.kotlinXCollections)
    implementation(Library.Androidx.splash)

    //Google material
    implementation(Library.Material.material)

    //Android X
    implementation(Library.Androidx.coreKtx)
    implementation(Library.Androidx.workRuntime)
    implementation(Library.Androidx.workRuntimeKtxExt)

    //Hilt
    implementation(Library.Hilt.core)
    kapt(Library.Hilt.compiler)

    //Accompanist
    implementation(Library.Accompanist.navigation)
    implementation(Library.Accompanist.pager)
    implementation(Library.Accompanist.pagerIndicators)
    implementation(Library.Accompanist.systemUiController)

    // Compose
    val composeBom = platform(Library.Compose.composeBillOfMaterials)
    implementation(composeBom)
    implementation(Library.Compose.activity)
    implementation(Library.Compose.ui)
    implementation(Library.Compose.compiler)
    implementation(Library.Compose.animation)
    implementation(Library.Compose.foundation)
    implementation(Library.Compose.foundationLayout)
    implementation(Library.Compose.material)
    implementation(Library.Compose.material3)
    implementation(Library.Compose.constraint)

    //Accompanist
    androidTestImplementation(Library.Accompanist.navigation)
    androidTestImplementation(Library.Accompanist.pager)
    androidTestImplementation(Library.Accompanist.pagerIndicators)
    androidTestImplementation(Library.Accompanist.systemUiController)

    androidTestImplementation(Library.Androidx.Test.testJunit)
    androidTestImplementation(Library.Androidx.Test.testRules)
    androidTestImplementation(Library.Androidx.Test.uiautomator)
    androidTestImplementation(Library.Androidx.Test.espresso)
    androidTestImplementation(Library.Compose.activity)
    androidTestImplementation(Library.Compose.composeUiTestJunit)
    androidTestImplementation(Library.turbine)
    androidTestImplementation(Library.Androidx.Test.testRunner)
    androidTestImplementation(composeBom)
    testImplementation(Library.mockk)
    testImplementation(Library.Androidx.Test.archCoreTest)
    androidTestImplementation(Library.Hilt.Test.hiltAndroidTest)
    kaptAndroidTest(Library.Hilt.compiler)

    //firebase
    implementation(platform(Library.Firebase.firebaseBillOfMaterials))
    implementation(Library.Firebase.firebaseConfig)
    implementation(Library.Firebase.firebaseAnalytics)

    //datastore
    implementation(Library.Androidx.preferenceDataStore)
}