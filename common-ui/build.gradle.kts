plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.nextflix.kotlin.android)
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    namespace = "com.talhafaki.common"
}

dependencies {
    implementation(projects.domain)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.ui.tooling)

    // Coil
    implementation(libs.coil)

    // Lottie
    implementation(libs.compose.lottie)
}