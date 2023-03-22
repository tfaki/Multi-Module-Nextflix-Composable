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
    implementation(project(":common"))

    implementation(Libs.composeUi)
    implementation(Libs.composeMaterial)

    // Hilt
    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)
    implementation(Libs.hiltNavigationCompose)

    // Paging
    implementation(Libs.pagingCompose)

    // Sweet Toast
    implementation(Libs.sweetToast)

    // Lottie
    implementation(Libs.lottieCompose)

    // Swipe Refresh
    implementation(Libs.swipeRefresh)

    implementation(Libs.retrofit)
}