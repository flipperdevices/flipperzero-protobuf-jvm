# Flipper JVM Protobuf

 [![Release](https://jitpack.io/v/flipperdevices/flipperzero-protobuf-jvm.svg)](https://jitpack.io/#flipperdevices/flipperzero-protobuf-jvm)

JVM library using git submodule from [repository](https://github.com/flipperdevices/flipperzero-protobuf) to simplify implementation

![flipper-white](https://user-images.githubusercontent.com/35292229/165945177-8b160087-ce55-46be-a3df-a147f610aef8.png#gh-light-mode-only)
![flipper-black](https://user-images.githubusercontent.com/35292229/165945977-5b86227f-9286-4c6a-9dc0-beaa51dc51b9.png#gh-dark-mode-only)

### How to use:
```kotlin
implementation("com.flipperdevices.protobuf")
```

### Architecture

- `/buildSrc` - variables for gradle and configuration maven library
- `/protobuf` - generate java/kotlin files by proto
- `.gitmodules` - connect sudmodule from [repository](https://github.com/flipperdevices/flipperzero-protobuf)
