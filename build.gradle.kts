import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
    maven
}

group = "dev.dakoda"
version = "0.3.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.junit.jupiter", "junit-jupiter-api", "5.3.1")
    implementation("org.assertj", "assertj-core", "3.11.1")
    runtimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.3.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}