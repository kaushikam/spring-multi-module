rootProject.name = "spring-multi-module"
include("student")
include("classroom")

rootProject.children.forEach { subProject ->
    subProject.buildFileName = "${subProject.name}.gradle.kts"
}
