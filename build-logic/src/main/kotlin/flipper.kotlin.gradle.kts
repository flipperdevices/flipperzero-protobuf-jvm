plugins {
  id("org.jetbrains.kotlin.jvm")
}

configure<JavaPluginExtension> {
  withSourcesJar()
  sourceCompatibility = JavaVersion.VERSION_1_7
  targetCompatibility = JavaVersion.VERSION_1_7
}

tasks.withType<Jar> {
  exclude("*.proto")
  exclude(".github")
  exclude("**/.DS_Store")
}
