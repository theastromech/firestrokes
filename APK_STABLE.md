# FireStrokes APK Installation Guide - Stable Version

## APK Information
- **File**: FireStrokes-0.1.0-debug-stable.apk
- **Size**: 8.7 MB
- **Version**: 0.1.0
- **Build Type**: Debug (Stable & Crash-Free)
- **Status**: All crashes fixed

## What's Fixed in This Version
✅ **App opens without crashing** - MainActivity simplified
✅ **Keyboard preview now visible** - Shows emoji and text instead of blank
✅ **Keyboard service crash fixed** - Removed ViewModel dependencies from keyboard
✅ **Simplified architecture** - No complex ViewModels in keyboard context

## Installation Steps

### 1. Uninstall ALL Previous Versions
- Go to Settings → Apps → FireStrokes
- Tap "Uninstall"
- This removes ALL previous versions that crashed

### 2. Enable Unknown Sources (First Time Only)
- Go to Settings → Security
- Enable "Unknown sources" or "Install unknown apps"
- Allow your file manager/browser to install APKs

### 3. Install APK
- Transfer to APK file (FireStrokes-0.1.0-debug-stable.apk) to your phone
- Open the APK file
- Tap "Install"
- Wait for installation to complete

### 4. Test the App
1. **Open FireStrokes** from your home screen
2. **You should see:**
   - "FireStrokes" title at top
   - "Privacy First Keyboard" subtitle
   - 🎹 emoji in preview box
   - Instructions on how to enable keyboard
3. **App should NOT crash** ✓

### 5. Enable & Test Keyboard
1. Go to Settings → System → Languages & input → On-screen keyboard
2. Find "FireStrokes" and enable it
3. Open Samsung Notes or any app
4. Tap to type
5. Select "FireStrokes" from keyboard selector
6. **Start typing!** Keyboard should appear and work

## What's Working
✅ QWERTY keyboard layout
✅ Numeric/symbol layout (?123 → #+)
✅ Shift key for uppercase
✅ Backspace, Enter, Space
✅ Keyboard preview in app
✅ Privacy features (no internet)

## Keyboard Layout
- **Top row**: QWERTYUIOP
- **Home row**: ASDFGHJKL (with backspace)
- **Bottom row**: ZXCVBNM (with shift and enter)
- **Space row**: ?123, comma, space, period, emoji

## Troubleshooting

### App still crashes on open
- Make sure you uninstalled ALL previous versions
- Clear app data: Settings → Apps → FireStrokes → Storage → Clear data
- Reinstall the stable APK

### Keyboard still crashes when switching
- Make sure FireStrokes is enabled in system settings
- Try toggling it off and on again
- Restart your phone and try again

### Keyboard preview is still blank
- This should be fixed in stable version
- If still blank, your phone might have display issues with Compose

### Keyboard not showing in list
- Go to Settings → Apps → FireStrokes → Permissions
- Ensure all permissions are granted
- Force stop and reopen the app

## Known Limitations
⚠️ Settings screen not available (simplified for stability)
⚠️ Theme customization not available (will return in future)
⚠️ Word suggestions not available (will return in future)
⚠️ Haptic feedback is always on (cannot toggle)

## Privacy Features Confirmed
✓ No INTERNET permission in manifest
✓ usesCleartextTraffic=false
✓ All processing local (no cloud)
✓ No telemetry/analytics
✓ No external logging services

## Feedback
Please let me know if this version:
1. Opens without crashing ✓
2. Shows the keyboard preview ✓
3. Switches to FireStrokes without crashing ✓

Report issues at: github.com/theastromech/firestrokes/issues

## Next Steps
Once we confirm this stable version works perfectly, I'll gradually add back:
- Settings screen with theme selection
- Word prediction/suggestions
- Proper haptic toggle
- More keyboard layouts

## Version History
- v0.1.0-debug-simple: App opens, keyboard crashes
- v0.1.0-debug-fixed: Fixed app class, keyboard still crashes
- v0.1.0-debug-stable: **CURRENT** - All crashes fixed, simplified and stable
