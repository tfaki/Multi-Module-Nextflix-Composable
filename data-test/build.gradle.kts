plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(projects.domain)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.junit)
}
