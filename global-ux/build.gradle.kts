import com.rahul.jott.gradle.Android
import com.rahul.jott.gradle.Library

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version com.rahul.jott.gradle.Version.kotlin
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    namespace = "com.rahul.jott.global"

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false // todo - enable obfuscation
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
}

dependencies {
    implementation(project(":dsm"))

    implementation(Library.Androidx.coreKtx)
    implementation(Library.Material.material)
    implementation(Library.Androidx.preferenceDataStore)

    implementation(Library.Kotlin.kotlinxSerialization)
    implementation(Library.Androidx.lifecycleRuntimeKtx)

    // Compose
    implementation(platform(Library.Compose.composeBillOfMaterials))
    implementation(Library.Compose.ui)
    implementation(Library.Compose.activity)
    implementation(Library.Compose.foundation)
    implementation(Library.Compose.material)
    implementation(Library.Compose.material3)
    implementation(Library.Compose.toolingPreview)

    //Coil
    implementation(Library.Coil.core)
    implementation(Library.Coil.compose)

    //Hilt
    implementation(Library.Hilt.core)
    kapt(Library.Hilt.compiler)

    //Google Play Services
    implementation(Library.GooglePlayServices.location)
    implementation(Library.Kotlin.coroutinesPlayServices)

    testImplementation(Library.junit)
    testImplementation(Library.coroutinesTest)
    testImplementation(Library.mockk)
    testImplementation(Library.Androidx.Test.archCoreTest)
    testImplementation(Library.turbine)
}