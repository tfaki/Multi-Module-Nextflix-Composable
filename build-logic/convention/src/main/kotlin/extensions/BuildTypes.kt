package extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *>
) {
    commonExtension.apply {
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}