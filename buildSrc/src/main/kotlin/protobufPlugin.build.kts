import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.protoc
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version

plugins {
    id("kotlin-jvm")
    id("com.google.protobuf")
}

dependencies {
    api("com.google.protobuf:protobuf-kotlin-lite:${Versions.protobuf}")
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
