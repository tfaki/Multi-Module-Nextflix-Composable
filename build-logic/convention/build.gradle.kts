import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
     implementation(libs.build.gradle.plugin)
     implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApp") {
            id = "nextflix.application"
            implementationClass = "plugins.AndroidApplicationComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "nextflix.hilt"
            implementationClass = "plugins.AndroidHiltConventionPlugin"
        }
        register("androidKotlin"){
            id = "nextflix.kotlin.android"
            implementationClass = "plugins.AndroidKotlinConventionPlugin"
        }
        register("androidLibrary"){
            id = "nextflix.library"
            implementationClass = "plugins.AndroidLibraryComposeConventionPlugin"
        }
    }
}