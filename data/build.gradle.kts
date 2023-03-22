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
    implementation(project(":domain"))
    implementation(Libs.coroutineAndroid)
    implementation(Libs.coroutineCore)
    implementation(Libs.inject)

    // Networking
    implementation(Libs.retrofit)
    implementation(Libs.converterGson)
    implementation(Libs.converterScalars)
    implementation(Libs.okhttpLogging)

    // Testing
    testImplementation(Libs.junit)
    testImplementation(Libs.coroutinesTest)
    testImplementation(Libs.extJunit)
    testImplementation(Libs.hiltTesting)
    kaptTest(Libs.hiltCompiler)

    kaptAndroidTest(Libs.hiltCompiler)
    implementation(Libs.hiltTesting)
    implementation(Libs.espresso)
}