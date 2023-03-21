plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk =  Sdk.compile

    defaultConfig {
        minSdk = Sdk.min
        targetSdk = Sdk.target

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
        kotlinCompilerExtensionVersion = Kotlin.compilerExtension
        kotlinCompilerVersion = Kotlin.compiler
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":common"))

    implementation("androidx.compose.ui:ui:${AndroidX.compose}")
    implementation("androidx.compose.material:material:1.3.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Google.hilt}")
    kapt("com.google.dagger:hilt-compiler:${Google.hilt}")
    implementation("androidx.hilt:hilt-navigation-compose:${AndroidX.hiltNavigationCompose}")

    // Paging
    implementation("androidx.paging:paging-compose:${AndroidX.pagingCompose}")

    // Sweet Toast
    implementation("com.github.TalhaFaki:ComposableSweetToast:1.0.0")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:4.2.0")

    implementation("com.squareup.retrofit2:retrofit:${Network.retrofit}")
}