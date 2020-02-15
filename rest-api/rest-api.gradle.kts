plugins {
	kotlin("plugin.spring")
	id("org.springframework.boot")
	war
}

tasks.withType<War> {
	archiveBaseName.set("student")
	archiveVersion.set(project.version.toString())
}

dependencies {
	implementation(project(":student"))

	implementation("com.h2database:h2")
	// Hibernate Cache
	implementation("org.hibernate:hibernate-ehcache")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// DBUnit
	testImplementation("org.dbunit:dbunit:2.6.0")
	testImplementation("com.github.database-rider:rider-core:1.7.2")
	testImplementation("com.github.database-rider:rider-spring:1.7.2"){
		exclude(group="org.slf4j", module="slf4j-simple")
	}
	testImplementation("com.github.database-rider:rider-junit5:1.7.2")
}

val execProfile: () -> String by extra
apply(from=execProfile)