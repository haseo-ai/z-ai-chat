# Z AI Chat

[한국어](README.md) | [English](README_EN.md) | [中文](README_ZH.md)

---

A Capacitor webview app that runs chat.z.ai as an Android application.

## 📱 Project Information

| Item | Value |
|------|-------|
| App Name | Z AI Chat |
| Package Name | com.zai.chat |
| Minimum Version | Android 12 (API 31) |
| Target Version | Android 15 (API 35) |
| Website | https://chat.z.ai |

## 🛠 Tech Stack

- **Frontend**: Next.js 16 + React 19 + TypeScript
- **Styling**: Tailwind CSS 4 + shadcn/ui
- **Mobile**: Capacitor 8
- **Platform**: Android (Gradle 8.14, AGP 8.5.2)

## 📂 Project Structure

```
├── android/                 # Android native project
│   ├── app/
│   │   ├── src/main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── assets/public/   # Web app files
│   │   │   └── res/             # Resources
│   │   └── build.gradle
│   ├── build.gradle
│   ├── variables.gradle
│   └── settings.gradle
├── src/app/                 # Next.js web app
│   ├── page.tsx
│   ├── layout.tsx
│   └── globals.css
├── public/
│   ├── icons/               # App icons
│   └── manifest.json        # PWA manifest
├── capacitor.config.ts      # Capacitor config
├── next.config.ts
└── package.json
```

## 🚀 Building APK

### Prerequisites

- Android Studio (Panda2 or later recommended)
- JDK 17+
- Node.js 18+ & Bun

### 1. Build Web App

```bash
bun install
bun run build
```

### 2. Sync Capacitor

```bash
bunx cap sync android
```

### 3. Build in Android Studio

1. Launch Android Studio
2. `File → Open` → Select `android` folder
3. Wait for Gradle sync
4. `Build → Make Project` (Ctrl+F9)
5. Run `:app → Tasks → build → assembleDebug` in Gradle tab

### 4. APK Location

```
android/app/build/outputs/apk/debug/app-debug.apk
```

## 📲 Installation

1. Transfer APK to Android device
2. Open APK in file manager
3. Allow "Install unknown apps"
4. Installation complete

## 🔧 Development

### Run Development Server

```bash
bun run dev
```

### Sync After Web App Changes

```bash
bun run build
bunx cap sync android
```

### Open Android Project

```bash
bunx cap open android
```

## 🔄 App Updates

When the website (chat.z.ai) is updated, you don't need to rebuild the app. The app automatically loads the latest version of the website.

## 📋 Permissions

| Permission | Purpose |
|------------|---------|
| INTERNET | Website access |
| CAMERA | Camera usage (optional) |
| RECORD_AUDIO | Voice input (optional) |
| POST_NOTIFICATIONS | Notifications (Android 13+) |
| READ_MEDIA_* | Media file access (Android 13+) |

## 🐛 Troubleshooting

### Gradle Sync Failed

- Verify JDK 17+ is installed
- Delete `android/.gradle` folder and retry

### Webpage Not Loading

- Check internet connection
- Verify chat.z.ai is accessible

### Permission Issues

- Manually grant camera/microphone permissions in app settings

## 📄 License

MIT License

## 🔗 Links

- [chat.z.ai](https://chat.z.ai)
- [Capacitor Documentation](https://capacitorjs.com/docs)
- [Next.js Documentation](https://nextjs.org/docs)
