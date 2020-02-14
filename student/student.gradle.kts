import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("plugin.jpa")
    kotlin("plugin.spring")
    kotlin("plugin.allopen")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

tasks.withType<BootJar> { enabled = false }

dependencies {
    implementation("com.h2database:h2")
    // Hibernate Cache
    implementation("org.hibernate:hibernate-ehcache")

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

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

