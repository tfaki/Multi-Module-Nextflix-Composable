dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "Nextflix-Composable"
include(":app")
include(":domain")
include(":data")
include(":common-ui")
include(":upcoming")
include(":nowplaying")
include(":popular")
