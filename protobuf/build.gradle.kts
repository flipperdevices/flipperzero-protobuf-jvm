plugins {
    id("maven-publish")
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
