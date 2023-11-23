import com.rahul.jott.gradle.Android
import com.rahul.jott.gradle.Version

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    namespace = "com.rahul.jott.dsm"

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false // todo - enable obfuscation
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCompiler
    }
}

dependencies {

    implementation(com.rahul.jott.gradle.Library.Androidx.coreKtx)
    implementation(com.rahul.jott.gradle.Library.Material.material)
    implementation(com.rahul.jott.gradle.Library.Androidx.splash)

    // Compose
    implementation(platform(com.rahul.jott.gradle.Library.Compose.composeBillOfMaterials))
    implementation(com.rahul.jott.gradle.Library.Compose.ui)
    implementation(com.rahul.jott.gradle.Library.Compose.tooling)
    implementation(com.rahul.jott.gradle.Library.Compose.toolingPreview)
    implementation(com.rahul.jott.gradle.Library.Compose.foundation)
    implementation(com.rahul.jott.gradle.Library.Compose.material)
    implementation(com.rahul.jott.gradle.Library.Compose.material3)
    implementation(com.rahul.jott.gradle.Library.Compose.constraint)

    // Accompanist
    implementation(com.rahul.jott.gradle.Library.Accompanist.systemUiController)
    implementation(com.rahul.jott.gradle.Library.Accompanist.placeHolder)

    //Coil
    implementation(com.rahul.jott.gradle.Library.Coil.core)
    implementation(com.rahul.jott.gradle.Library.Coil.compose)
    implementation("androidx.core:core-ktx:+")
}