// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.buildGradlePlugin)
        classpath(Libs.kotlinGradlePlugin)
        classpath(Libs.hiltGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

task("clean") {
    delete(project.buildDir)
}