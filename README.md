# FireStrokes

A privacy-first, open-source Android keyboard built with Kotlin and Jetpack Compose.

## Privacy Guarantees

- **Zero Network Access**: No INTERNET permission - your typing data never leaves your device
- **No Cloud Services**: All processing happens locally on your device
- **No Telemetry**: No analytics or tracking of any kind
- **Open Source**: Fully transparent codebase you can audit

## Tech Stack

- **Language**: Kotlin 1.9.0
- **Compile SDK**: 34 (Android 14)
- **Min SDK**: 24 (Android 7.0+)
- **UI Framework**: Jetpack Compose (BOM 2023.10.01) with Material 3
- **Architecture**: MVVM + Clean Architecture
- **Dependency Injection**: Koin 3.5.0
- **Coroutines**: kotlinx-coroutines-android 1.7.3
- **Build System**: Gradle (Kotlin DSL)

## Project Status

**Current Version**: 0.1.0  
**Status**: Stage 1 - Project Initialization Complete

## Building

```bash
./gradlew assembleDebug
```

## Privacy Features

- UsesCleartextTraffic disabled by default
- No external network libraries
- All input processing is local
- No Firebase, no Crashlytics, no analytics

## License

[Specify your license here]

## Contributing

[Specify your contribution guidelines here]
