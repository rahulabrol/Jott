@file:Suppress("UnstableApiUsage")

import com.rahul.jott.gradle.Android
import com.rahul.jott.gradle.Library

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.rahul.jott.networking"

    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    //Hilt
    implementation(Library.Hilt.core)
    kapt(Library.Hilt.compiler)

    testImplementation(Library.junit)

    androidTestImplementation(Library.Androidx.Test.testJunit)
    androidTestImplementation(Library.Androidx.Test.espresso)
}