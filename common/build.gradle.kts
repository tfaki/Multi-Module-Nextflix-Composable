plugins {
    id("com.android.library")
    id("kotlin-android")
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
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(project(":domain"))

    implementation("androidx.compose.ui:ui:${AndroidX.compose}")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.compose.ui:ui-tooling:${AndroidX.compose}")

    // Coil
    implementation("io.coil-kt:coil-compose:${CoilKt.coil}")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:4.2.2")
}