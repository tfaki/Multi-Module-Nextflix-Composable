plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.kotlin.kapt")
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
    // Build fails after adding the test coroutines dependency
    // https://github.com/Kotlin/kotlinx.coroutines/issues/2023
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(projects.domain)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.inject)

    // Networking
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.scalars)
    implementation(libs.okhttp.logging)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.junit.ext)
    testImplementation(libs.hilt.testing)
    kaptTest(libs.hilt.compiler)

    kaptAndroidTest(libs.hilt.compiler)
    implementation(libs.hilt.testing)
    implementation(libs.espresso)
}