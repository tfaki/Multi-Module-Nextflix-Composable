plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.nextflix.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
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