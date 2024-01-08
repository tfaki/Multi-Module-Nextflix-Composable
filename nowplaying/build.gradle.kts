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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compilerExtension
    }
    namespace = "com.talhafaki.nowplaying"
}

dependencies {

    implementation(projects.domain)
    implementation(projects.commonUi)

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

    implementation(libs.retrofit)
}