val getConfig: () -> String by extra
apply(from=getConfig())

val applicationProperties: HashMap<String, String> by extra
applicationProperties["datasourceUsername"] = "eabacus"
applicationProperties["datasourcePassword"] = "redhat"
applicationProperties["datasourceUrl"] = "jdbc:h2:$rootDir/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM $rootDir/sql/init.sql"

tasks.getByName<ProcessResources>("processTestResources") {
    filesMatching(listOf("test-application.properties", "dbunit.yml")) {
        expand(applicationProperties)
    }
}


