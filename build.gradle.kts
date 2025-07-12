plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.json:json:20210307")
    implementation("org.apache.pdfbox:pdfbox:2.0.27")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}