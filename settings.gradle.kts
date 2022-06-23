pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}

rootProject.name = "flipperzero-protobuf-jvm"

includeBuild("build-logic")
include(
  "protobuf",
  "protobuf-metric",
)
