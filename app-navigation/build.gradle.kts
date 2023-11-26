import com.rahul.jott.gradle.Android
import com.rahul.jott.gradle.Library

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    namespace = "com.rahul.jott.app.navigation"

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = false
        compose = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false // todo - enable obfuscation
        }
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

    implementation(project(":global-ux"))
    implementation(project(":navigation"))
    implementation(project(":dsm"))
    implementation(project(":home"))
    implementation(project(":networking"))

    //Android X
    implementation(Library.Androidx.coreKtx)
    implementation(Library.Androidx.workRuntime)
    implementation(Library.Androidx.workRuntimeKtxExt)
    implementation(Library.Androidx.viewModel)
    implementation(Library.Androidx.viewModelCompose)

    //Navigation
    implementation(Library.Androidx.navigationCompose)
    implementation(Library.Androidx.hiltNavigationCompose)
    implementation(Library.Androidx.navigationUIKtx)

    // Accompanist
    implementation(Library.Accompanist.navigation)
    implementation(Library.Accompanist.pager)
    implementation(Library.Accompanist.pagerIndicators)
    implementation(Library.Accompanist.systemUiController)

    // Hilt
    implementation(Library.Hilt.core)
    kapt(Library.Hilt.compiler)

    // Compose
    implementation(platform(Library.Compose.composeBillOfMaterials))
    implementation(Library.Compose.activity)
    implementation(Library.Compose.ui)
    implementation(Library.Compose.compiler)
    implementation(Library.Compose.toolingPreview)
    implementation(Library.Compose.animation)
    implementation(Library.Compose.foundation)
    implementation(Library.Compose.foundationLayout)
    implementation(Library.Compose.material)
    implementation(Library.Compose.material3)
    implementation(Library.Compose.constraint)

    //firebase
    implementation(platform(Library.Firebase.firebaseBillOfMaterials))
    implementation(Library.Firebase.firebaseConfig)

    implementation(Library.GooglePlayServices.gmsTasks)
}