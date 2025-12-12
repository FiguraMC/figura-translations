plugins {
    id("java-library")
    id("maven-publish")
}

group = "org.figuramc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.11.0")
}

java {
    withSourcesJar()

    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}