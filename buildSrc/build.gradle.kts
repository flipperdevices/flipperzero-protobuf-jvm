plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", version = "1.6.20"))
    implementation(kotlin("stdlib", version = "1.6.20"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.6.20")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.6.20")
    implementation("com.google.protobuf:protobuf-gradle-plugin:0.8.18")
}

