/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    // https://docs.gradle.org/current/userguide/sharing_build_logic_between_subprojects.html
    // https://docs.gradle.org/current/samples/sample_convention_plugins.html
    // https://plugins.gradle.org/

    implementation("io.spring.gradle:dependency-management-plugin:1.1.0")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.7.10")
}
