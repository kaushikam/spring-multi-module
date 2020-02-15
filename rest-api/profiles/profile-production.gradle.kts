val getConfig: () -> String by extra
apply(from=getConfig())

val applicationProperties: HashMap<String, String> by extra
applicationProperties["datasourceUsername"] = "sa"
applicationProperties["datasourcePassword"] = ""
applicationProperties["datasourceUrl"] = "jdbc:h2:mem:student"

tasks.getByName<ProcessResources>("processTestResources") {
	filesMatching("dbunit.yml") {
		expand(applicationProperties)
	}
}

tasks.getByName<ProcessResources>("processResources") {
	filesMatching("application.properties") {
		expand(applicationProperties)
	}
}