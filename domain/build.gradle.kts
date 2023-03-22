plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(Libs.coroutineCore)
    implementation(Libs.inject)
    
    implementation(Libs.retrofit)
}