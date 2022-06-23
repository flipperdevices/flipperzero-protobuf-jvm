plugins {
  id("maven-publish")
}

configure<PublishingExtension> {
  publications {
    create<MavenPublication>("maven") {
      groupId = System.getProperty("group", "com.github.flipperdevices")
      version = System.getProperty("version", "debug")

      from(components["java"])
    }
  }
}
