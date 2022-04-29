import java.lang.System.getProperty

object Configuration {
    val version = getProperty("version", "debug")
    val repository = getProperty("group", "com.github.flipperdevices")
    const val name = "protobuf-jvm"
}
