import com.google.protobuf.gradle.*
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.invoke

plugins {
  id("com.google.protobuf")
}

// https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()
dependencies {
  "api"(libs.protobuf.kotlinLite)
}

protobuf {
  protoc {
    // https://github.com/google/protobuf-gradle-plugin/issues/563
    artifact = libs.protobuf.protoc.get().toString()
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

configure<SourceSetContainer> {
  getByName("main") {
    java {
      // https://github.com/google/protobuf-gradle-plugin/issues/109
      val protobufConvention = project.convention.getPlugin(ProtobufConvention::class.java)
      srcDir("${protobufConvention.protobuf.generatedFilesBaseDir}/main/java")
      srcDir("${protobufConvention.protobuf.generatedFilesBaseDir}/main/kotlin")
    }
  }
}
