plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.inject)
    
    implementation(libs.retrofit)
}