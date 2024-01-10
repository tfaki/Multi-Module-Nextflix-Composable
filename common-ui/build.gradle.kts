plugins {
    alias(libs.plugins.nextflix.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.nextflix.kotlin.android)
}

android {
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    namespace = "com.talhafaki.common"
}

dependencies {
    implementation(projects.domain)

    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.ui.tooling)

    // Coil
    implementation(libs.coil)

    // Lottie
    implementation(libs.compose.lottie)
}