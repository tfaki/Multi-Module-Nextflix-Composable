plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
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
    // Build fails after adding the test coroutines dependency
    // https://github.com/Kotlin/kotlinx.coroutines/issues/2023
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    namespace = "com.talhafaki.data"
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
    kspTest(libs.hilt.compiler)

    kspAndroidTest(libs.hilt.compiler)
    implementation(libs.hilt.testing)
    implementation(libs.espresso)
}