# FireStrokes APK Installation Guide

## APK Information
- **File**: FireStrokes-0.1.0-debug-fixed.apk
- **Size**: 8.7 MB
- **Version**: 0.1.0
- **Build Type**: Debug
- **Fix**: Application class registered in manifest

## Installation Steps

### 1. Uninstall Previous Version (if any)
- Go to Settings → Apps → FireStrokes
- Tap "Uninstall"
- This removes the crashed version

### 2. Enable Unknown Sources (First Time Only)
- Go to Settings → Security
- Enable "Unknown sources" or "Install unknown apps"
- Allow your file manager/browser to install APKs

### 3. Install APK
- Transfer the new APK file (FireStrokes-0.1.0-debug-fixed.apk) to your phone
- Open the APK file
- Tap "Install"
- Wait for installation to complete

### 4. Enable Keyboard
After installation:
1. Go to Settings → System → Languages & input → On-screen keyboard
2. Find "FireStrokes" in the list
3. Enable it
4. Switch to FireStrokes when typing in any app

### 5. Privacy Verification
- Check app permissions - it should NOT have INTERNET permission
- All typing happens locally on your device
- No data is sent to any external servers

## Testing Tips

1. **Open app first**: Launch FireStrokes app from home screen
2. **Test settings**: Change theme, toggle haptic feedback
3. **Test in apps**: Try messaging, browser, notes
4. **Test layouts**: QWERTY, Numbers/Symbols (?123)
5. **Test predictions**: Type common words to see suggestions
6. **Test special keys**: Shift, Backspace, Enter, Space

## What Was Fixed

**Previous Issue**: App crashed on startup
**Root Cause**: Application class not registered in AndroidManifest
**Solution**: Added `android:name=".FireStrokesApplication"` to manifest
This ensures Koin dependency injection initializes before the UI loads

## Troubleshooting

### Still crashes
- Clear app data: Settings → Apps → FireStrokes → Storage → Clear data
- Reinstall the APK
- Ensure Android 7.0+ (API 24+)

### Keyboard not showing in list
- Go to Settings → Apps → FireStrokes → Permissions
- Ensure all permissions are granted
- Force stop and reopen the app

### Keyboard not switching
- Make sure FireStrokes is enabled in system settings
- Try toggling it off and on again

### Settings won't open
- This is normal if keyboard service isn't running
- Open the main FireStrokes app from home screen instead

## Privacy Features Confirmed
✓ No INTERNET permission
✓ usesCleartextTraffic=false
✓ All processing local
✓ No telemetry/analytics
✓ No cloud services

## Feedback
Please report issues or suggestions at GitHub repository!
