import com.google.protobuf.gradle.proto

plugins {
  id("flipper.kotlin")
  id("flipper.publish")
  id("flipper.protobuf")
}

sourceSets {
  main {
    proto {
      srcDir("$projectDir/flipperzero-protobuf")
    }
  }
}

publishing {
  publications {
    getByName<MavenPublication>("maven") {
      artifactId = "protobuf-jvm"
    }
  }
}
