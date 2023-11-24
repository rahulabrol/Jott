import com.rahul.jott.gradle.Android
import com.rahul.jott.gradle.Library
import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version com.rahul.jott.gradle.Version.kotlin

    val navigationSafeArg = com.rahul.jott.gradle.Library.Plugin.Id.navigationSafeArg

    id(navigationSafeArg)
    `maven-publish`
    id("kotlin-parcelize")

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

val autoUpdate get() = (System.getenv("autoUpdate") ?: "true").toBoolean()

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    ndkVersion = com.rahul.jott.gradle.Version.ndkVersion

    namespace = "com.rahul.jott"

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // testBuildType = System.getProperty("testBuildType", "debug")
    }

    buildTypes {
        val githubProperties = Properties()

        if (file("${project.rootDir}/github.properties").exists()) {
            try {
                githubProperties.load(FileInputStream(rootProject.file("github.properties")))
            } catch (e: Exception) {
                println(e.toString())
            }
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = false
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = com.rahul.jott.gradle.Version.composeCompiler
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree("include" to listOf("*.jar"), "dir" to "libs"))
    implementation(Library.Kotlin.kotlinStdlibJdk8)
    implementation(Library.Kotlin.coroutinesPlayServices)

    implementation(project(":navigation"))
    implementation(project(":dsm"))
    implementation(project(":global-ux"))

    //Coil
    implementation(Library.Coil.core)
    implementation(Library.Coil.compose)

    //Google material
    implementation(Library.Material.material)

    //Android X
    implementation(Library.Androidx.annotation)
    implementation(Library.Androidx.liveData)
    implementation(Library.Androidx.viewModel)
    implementation(Library.Androidx.viewModelCompose)
    implementation(Library.Androidx.coreKtx)
    implementation(Library.Androidx.lifecycleCommonJava8)
    implementation(Library.Androidx.lifecycleRuntimeKtx)
    implementation(Library.Androidx.lifecycleRuntimeCompose)
    implementation(Library.Androidx.workRuntime)
    implementation(Library.Androidx.workRuntimeKtxExt)
    implementation(Library.Androidx.startup)

    kapt(Library.Androidx.lifecycleCommonJava8)

    //Navigation
    implementation(Library.Androidx.navigationCompose)
    implementation(Library.Androidx.hiltNavigationCompose)
    implementation(Library.Androidx.navigationUIKtx)

    //Google Play Services
    implementation(Library.GooglePlayServices.location)

    //Accompanist
    implementation(Library.Accompanist.navigation)
    implementation(Library.Accompanist.pager)
    implementation(Library.Accompanist.pagerIndicators)

    // Compose
    val composeBom = platform(Library.Compose.composeBillOfMaterials)
    implementation(composeBom)
    implementation(Library.Compose.ui)
    implementation(Library.Compose.activity)
    implementation(Library.Compose.compiler)
    implementation(Library.Compose.toolingPreview)
    implementation(Library.Compose.animation)
    implementation(Library.Compose.foundation)
    implementation(Library.Compose.foundationLayout)
    implementation(Library.Compose.material)
    implementation(Library.Compose.constraint)

    implementation(Library.Kotlin.kotlinxSerialization)

    //Hilt
    implementation(Library.Hilt.core)
    kapt(Library.Hilt.compiler)

    testImplementation(Library.junit)
    testImplementation(Library.coroutinesTest)
    testImplementation(Library.mockk)
    testImplementation(Library.Androidx.Test.archCoreTest)
    testImplementation(Library.turbine)

    debugImplementation(Library.leakcanary)
}
