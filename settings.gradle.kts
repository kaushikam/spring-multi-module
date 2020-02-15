rootProject.name = "spring-multi-module"
include("student")
include("rest-api")

rootProject.children.forEach { subProject ->
    subProject.buildFileName = "${subProject.name}.gradle.kts"
}
