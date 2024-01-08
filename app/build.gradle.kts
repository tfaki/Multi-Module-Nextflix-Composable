plugins {
    alias(libs.plugins.nextflix.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.nextflix.hilt)
}

android {
    defaultConfig {
        applicationId = "com.talhafaki.nextflixcomposable"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    namespace = "com.talhafaki.nextflixcomposable"
}

dependencies {

    implementation(projects.domain)
    implementation(projects.data)
    implementation(projects.commonUi)
    implementation(projects.upcoming)
    implementation(projects.nowplaying)
    implementation(projects.popular)

    // Kotlin Coroutines
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)

    // AndroidX
    implementation(libs.android.ktx)
    implementation(libs.appcompat)
    implementation(libs.lifecycle)
    implementation(libs.lifecycle.viewmodel)

    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.material.icon.core)
    implementation(libs.compose.runtime)
    implementation(libs.compose.activity)
    implementation(libs.compose.navigation)
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.paging)

    // Networking
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.scalars)
    implementation(libs.okhttp.logging)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.hilt.testing)
    implementation(libs.junit.ext)
    implementation(libs.espresso)

}