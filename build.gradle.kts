import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    group = "com.kaushikam"
    version = "0.0.1"
}

plugins {
    base
    kotlin("jvm") version ("1.3.61") apply false
    kotlin("plugin.spring") version ("1.3.61") apply false
    kotlin("plugin.jpa") version ("1.3.61") apply false
    kotlin("plugin.allopen") version ("1.3.61") apply false
    id ("org.springframework.boot") version ("2.2.1.RELEASE") apply false
    id ("io.spring.dependency-management") version ("1.0.8.RELEASE")
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("io.spring.dependency-management")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    dependencies {
        val implementation by configurations
        val testImplementation by configurations
        val testRuntimeOnly by configurations
        val annotationProcessor by configurations

        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))

        implementation("ch.qos.logback:logback-classic")
        implementation("org.codehaus.groovy:groovy:2.5.6")
        implementation("io.github.microutils:kotlin-logging:1.6.25")

        // Spring configuration processor
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        // Kotlin test libraries
        testImplementation(kotlin("test"))

        // Spring test
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
            exclude(module = "mockito-core")
        }

        // Mockk
        testImplementation("com.ninja-squad:springmockk:1.1.2")

        // Junit jupiter engine
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    // Profile specific lambda functions
    extra["execProfile"] = {
        val buildProfile: String by project
        var profileFileRelativePath = "profiles/profile-$buildProfile.gradle.kts"
        var profileFile = file(".").absoluteFile.resolve(profileFileRelativePath)
        if (!profileFile.exists())
            profileFileRelativePath = "profiles/profile-development.gradle.kts"
        profileFile = file(".").absoluteFile.resolve(profileFileRelativePath)
        profileFile.absolutePath
    }
    extra.set("getConfig", {
        val configFileRelativePath = "profiles/common.gradle.kts"
        file(".").absoluteFile.resolve(configFileRelativePath).absolutePath
    })
}