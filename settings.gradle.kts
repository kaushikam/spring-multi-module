rootProject.name = "spring-multi-module"
include("student")

rootProject.children.forEach { subProject ->
    subProject.buildFileName = "${subProject.name}.gradle.kts"
}
