import java.lang.System.getProperty

object Configuration {
    const val version = getProperty("version", "debug")
    const val repository = getProperty("group", "com.github.flipperdevices")
    const val name = "protobuf-jvm"
}
