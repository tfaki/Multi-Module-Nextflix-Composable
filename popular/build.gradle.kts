plugins {
    alias(libs.plugins.nextflix.library)
    alias(libs.plugins.nextflix.hilt)
    alias(libs.plugins.nextflix.kotlin.android)
}

android {
    namespace = "com.talhafaki.popular"
}

dependencies {

    implementation(projects.domain)
    implementation(projects.commonUi)

    implementation(libs.compose.ui)
    implementation(libs.compose.material)

    // Hilt
    implementation(libs.compose.hilt.navigation)

    // Paging
    implementation(libs.compose.paging)

    // Sweet Toast
    implementation(libs.sweet.toast)

    // Lottie
    implementation(libs.compose.lottie)

    // Swipe Refresh
    implementation(libs.swipe.refresh)

    implementation(libs.retrofit)
}