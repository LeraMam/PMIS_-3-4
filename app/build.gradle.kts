@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.marvel"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.marvel"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")
    implementation("androidx.compose.ui:ui:1.0.0")
    implementation("androidx.compose.material:material:1.0.0")
    implementation("androidx.compose.ui:ui-tooling:1.0.0")
    implementation("androidx.compose.material3:material3")
    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha06")
    implementation("org.json:json:20210307")
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("androidx.compose.foundation:foundation:1.0.4")
    implementation ("androidx.compose.material:material:1.0.4")
    implementation ("androidx.compose.runtime:runtime:1.0.4")
    implementation ("androidx.compose.runtime:runtime-livedata:1.0.4")
    implementation ("androidx.compose.ui:ui:1.0.4")
    implementation ("androidx.compose.ui:ui-tooling:1.0.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(libs.room)
    implementation(libs.room.runtime)
    implementation(libs.paging.common)
    implementation(libs.paging.compose)
    implementation(libs.coil)
    implementation(libs.coil.compose)
    implementation(libs.accompanist.adaptive)
    implementation(libs.accompanist.drawablepainter)
    implementation(libs.accompanist.navigation.material)
    implementation(libs.accompanist.testharness)
    implementation(libs.accompanist.permissions)
    implementation(libs.compose.activity)
    implementation(libs.compose.animation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.graphics)
    implementation(libs.compose.material3)
    implementation(libs.compose.paging)
    implementation(libs.compose.runtime)
    implementation(libs.compose.tooling)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.util)
    implementation(libs.compose.viewmodel)
    implementation(libs.compose.preview)
    implementation(libs.androidx.core)
    implementation(libs.androidx.collection)
    implementation(libs.lifecycle.process)
    implementation(libs.lifecycle.service)
    implementation(libs.lifecycle.viewmodel)

    implementation(libs.ktor.auth)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.engine)
    implementation(libs.ksp)
    implementation(libs.kotlin.coroutines)
    implementation(libs.workmanager)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.kotlinx.serialization)
    implementation(libs.datastore)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}