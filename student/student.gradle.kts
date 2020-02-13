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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}