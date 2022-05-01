import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.proto
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    kotlin("jvm") version Versions.kotlin
    id("com.google.protobuf") version Versions.protobufPlugin
    id("maven-publish")
}

dependencies {
    implementation("com.google.protobuf:protobuf-javalite:${Versions.protobuf}")
    implementation("com.google.protobuf:protobuf-kotlin:${Versions.protobuf}")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${Versions.protobuf}"
    }
    generateProtoTasks {
        all().forEach {
            it.builtins {
                getByName("java") {
                    option("lite")
                }
                id("kotlin")
            }
        }
    }
}

sourceSets {
    main {
        proto {
            srcDir("$projectDir/flipperzero-protobuf")
        }
        java {
            // https://github.com/google/protobuf-gradle-plugin/issues/109
            srcDir("${protobuf.protobuf.generatedFilesBaseDir}/main/java")
            srcDir("${protobuf.protobuf.generatedFilesBaseDir}/main/kotlin")
        }
    }
}

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_1_6
    targetCompatibility = JavaVersion.VERSION_1_6
}

tasks.withType<Jar> {
    exclude("*.proto")
    exclude(".github")
    exclude("**/.DS_Store")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = Configuration.repository
            artifactId = Configuration.name
            version = Configuration.version

            from(components["java"])
        }
    }
}
