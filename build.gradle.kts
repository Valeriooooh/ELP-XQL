plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.antlr:antlr4:4.13.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}