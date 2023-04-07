plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compilerExtension
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":common-ui"))

    implementation(libs.compose.ui)
    implementation(libs.compose.material)

    // Hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    implementation(libs.compose.hilt.navigation)

    // Paging
    implementation(libs.compose.paging)

    // Sweet Toast
    implementation(libs.sweet.toast)

    // Lottie
    implementation(libs.compose.lottie)

    // Swipe Refresh
    implementation(libs.swipe.refresh)

    implementation(libs.retrofit)
}