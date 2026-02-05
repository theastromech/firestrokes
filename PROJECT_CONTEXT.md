# FireStrokes Project Context

## App Version
0.1.0

## Tech Stack
- **Language**: Kotlin 1.9.0
- **Compile SDK**: 34 (Android 14)
- **Min SDK**: 24 (Android 7.0)
- **UI Framework**: Jetpack Compose (BOM 2023.10.01) with Material 3
- **Architecture**: MVVM + Clean Architecture
- **Dependency Injection**: Koin 3.5.0
- **Coroutines**: kotlinx-coroutines-android 1.7.3
- **Build System**: Gradle (Kotlin DSL)

## Git Repo
git@github.com:theastromech/firestrokes.git

## Current Status
Stage 1: Project Initialization Complete - Code pushed to GitHub

## Completed Features
- [x] Git repository initialized with main branch
- [x] Remote origin configured
- [x] SSH key generated and added to GitHub
- [x] Initial code pushed to remote repository (main branch)
- [x] Clean Architecture folder structure created (data, domain, presentation, di)
- [x] Project-level build.gradle.kts configured
- [x] App-level build.gradle.kts with all dependencies
- [x] AndroidManifest.xml created with:
  - InputMethodService permission included
  - INTERNET permission intentionally omitted
  - usesCleartextTraffic="false" set
- [x] README.md with project description and privacy guarantees
- [x] Basic keyboard service stub (FireStrokesKeyboardService)
- [x] MainActivity with Jetpack Compose setup
- [x] Koin dependency injection configured
- [x] ProGuard rules created
- [x] Resource files (strings.xml, themes.xml, XML configs)

## Known Issues
- None (fresh project)

## Next Steps
1. Implement the keyboard UI layout using Jetpack Compose
2. Create the keyboard key press handling logic
3. Implement word prediction/suggestion system (local only)
4. Add keyboard theme customization
5. Implement swipe typing gesture recognition
6. Add settings screen for user preferences
7. Create dictionary management system
8. Implement clipboard history feature
9. Add multiple language support
10. Test on multiple Android versions (7.0 - 14)

## Privacy Checklist
- [x] INTERNET permission NOT in AndroidManifest.xml
- [x] usesCleartextTraffic="false" set in manifest
- [x] No Firebase or analytics libraries in dependencies
- [x] No Crashlytics or external logging services
- [x] All data processing is local
