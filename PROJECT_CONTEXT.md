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
Stage 2: Core Features Implemented - Ready for Testing

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
- [x] Full keyboard UI layout using Jetpack Compose with:
  - QWERTY layout
  - Numeric/symbol layouts
  - Responsive key sizing
  - Material 3 design system
- [x] Keyboard key press handling logic with:
  - Haptic feedback manager
  - InputConnection handling
  - Special key support (shift, backspace, enter)
  - Use case-based architecture
- [x] Local word prediction/suggestion system:
  - Trie-based autocomplete algorithm
  - Common words dictionary (privacy-first, no cloud)
  - Suggestion bar UI component
  - Real-time word suggestions
- [x] Keyboard theme customization:
  - 6 beautiful color themes (Default, Dark, Midnight, Ocean, Forest, Sunset)
  - Theme manager with SharedPreferences
  - Theme selector UI component
  - Dynamic theme switching
- [x] Settings screen for user preferences:
  - Theme selection
  - Haptic feedback toggle
  - System keyboard settings link
  - About section with privacy info
  - Material 3 design

## Known Issues
- None (all core features implemented)
- Swipe typing not yet implemented (low priority)
- Emoji picker not yet integrated (future enhancement)

## Next Steps
1. Implement swipe typing gesture recognition (optional enhancement)
2. Create dictionary management system (user word learning)
3. Implement clipboard history feature
4. Add multiple language support (international keyboards)
5. Add emoji picker integration
6. Implement voice typing (STT) (optional)
7. Add sound feedback options
8. Test on multiple Android versions (7.0 - 14)
9. Performance optimization and battery usage testing
10. Release version 0.2.0 with stable features

## Privacy Checklist
- [x] INTERNET permission NOT in AndroidManifest.xml
- [x] usesCleartextTraffic="false" set in manifest
- [x] No Firebase or analytics libraries in dependencies
- [x] No Crashlytics or external logging services
- [x] All data processing is local
