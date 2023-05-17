/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("com.zhpooer.demo.java-application-conventions")
    id("de.undercouch.download") version "5.4.0"
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.7")
        mavenBom("org.springframework.cloud:spring-cloud-sleuth-otel-dependencies:1.1.3")
    }
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth") {
        exclude("org.springframework.cloud", "spring-cloud-sleuth-brave")
    }
    implementation("org.springframework.cloud:spring-cloud-sleuth-instrumentation")
    implementation("org.springframework.cloud:spring-cloud-sleuth-otel-autoconfigure")
    implementation("io.opentelemetry:opentelemetry-exporter-otlp")
    implementation("io.opentelemetry:opentelemetry-exporter-jaeger")
    implementation(project(":utilities"))
}

tasks.getByName("bootJar") {
    dependsOn("downloadAgent")
}

task( "downloadAgent") {
    download.run {
        src("https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar")
        dest("${project.buildDir.toString()}/otel/opentelemetry-javaagent.jar")
    }
}

application {
    // Define the main class for the application.
    mainClass.set("com.zhpooer.demo.app.App")
}
