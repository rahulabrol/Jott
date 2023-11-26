@file:Suppress("UnstableApiUsage")

import com.rahul.jott.gradle.Android

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.priceline.android.networking"

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
    implementation(com.rahul.jott.gradle.Library.Hilt.core)
    kapt(com.rahul.jott.gradle.Library.Hilt.compiler)

    testImplementation(com.rahul.jott.gradle.Library.junit)

    androidTestImplementation(com.rahul.jott.gradle.Library.Androidx.Test.testJunit)
    androidTestImplementation(com.rahul.jott.gradle.Library.Androidx.Test.espresso)
}