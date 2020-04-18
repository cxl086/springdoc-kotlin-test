import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8


plugins {
    val kotlinVersion = "1.3.71"
    val bootVersion = "2.2.6.RELEASE"

    id("java")
    id("org.springframework.boot") version bootVersion
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
}

repositories {
    mavenLocal()
    mavenCentral()
}

val springdocVersion = "1.3.2"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springdoc:springdoc-openapi-ui:$springdocVersion")
    implementation("org.springdoc:springdoc-openapi-kotlin:$springdocVersion")

    kotlin("stdlib-jdk8")

}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
