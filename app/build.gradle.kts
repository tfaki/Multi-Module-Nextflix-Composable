plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = "com.talhafaki.nextflixcomposable"
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":common"))
    implementation(project(":upcoming"))
    implementation(project(":nowplaying"))
    implementation(project(":popular"))

    // Kotlin Coroutines
    implementation(Libs.coroutineAndroid)
    implementation(Libs.coroutineCore)

    // Hilt
    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)

    // AndroidX
    implementation(Libs.coreKtx)
    implementation(Libs.appcompat)
    implementation(Libs.lifecycle)
    implementation(Libs.lifecycleViewmodel)
    implementation(Libs.composeUi)
    implementation(Libs.composeMaterial)
    implementation(Libs.composeUiTooling)
    implementation(Libs.materialIconsCore)
    //implementation(Libs.materialIconsExtended)
    implementation(Libs.runtimeLiveData)
    implementation(Libs.activityCompose)
    implementation(Libs.navigationCompose)
    implementation(Libs.hiltNavigationCompose)
    implementation(Libs.pagingCompose)

    // Networking
    implementation(Libs.retrofit)
    implementation(Libs.converterGson)
    implementation(Libs.converterScalars)
    implementation(Libs.okhttpLogging)

    // Testing
    testImplementation(Libs.junit)
    testImplementation(Libs.hiltTesting)
    implementation(Libs.extJunit)
    implementation(Libs.espresso)

    // Google
    implementation(Libs.material)
}