# Z.AI WebView

[한국어](README.md) | [English](README_EN.md) | [中文](README_ZH.md)

---

> ⚠️ **비공식 프로젝트**: 이 앱은 chat.z.ai와 아무런 공식적인 관계가 없습니다.

chat.z.ai를 안드로이드 앱으로 실행하는 Capacitor 웹뷰 앱입니다. PWA 설치가 지원되지 않는 Android 12 이하 기기에서 독립 앱처럼 사용할 수 있습니다.

**🌐 배포 페이지**: https://haseo-ai.github.io/z-ai-chat

## 📱 프로젝트 정보

| 항목 | 값 |
|------|-----|
| 앱 이름 | Z AI Chat |
| 패키지명 | com.zai.chat |
| 최소 버전 | Android 12 (API 31) |
| 타겟 버전 | Android 15 (API 35) |
| 웹사이트 | https://chat.z.ai |

## 🛠 기술 스택

- **Frontend**: Next.js 16 + React 19 + TypeScript
- **Styling**: Tailwind CSS 4 + shadcn/ui
- **Mobile**: Capacitor 8
- **Platform**: Android (Gradle 8.14, AGP 8.5.2)

## 📂 프로젝트 구조

```
├── android/                 # 안드로이드 네이티브 프로젝트
│   ├── app/
│   │   ├── src/main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── assets/public/   # 웹 앱 파일
│   │   │   └── res/             # 리소스
│   │   └── build.gradle
│   ├── build.gradle
│   ├── variables.gradle
│   └── settings.gradle
├── src/app/                 # Next.js 웹 앱
│   ├── page.tsx
│   ├── layout.tsx
│   └── globals.css
├── public/
│   ├── icons/               # 앱 아이콘
│   └── manifest.json        # PWA 매니페스트
├── capacitor.config.ts      # Capacitor 설정
├── next.config.ts
└── package.json
```

## 🚀 APK 빌드 방법

### 사전 요구사항

- Android Studio (Panda2 이상 권장)
- JDK 17+
- Node.js 18+ & Bun

### 1. 웹 앱 빌드

```bash
bun install
bun run build
```

### 2. Capacitor 동기화

```bash
bunx cap sync android
```

### 3. 안드로이드 스튜디오에서 빌드

1. Android Studio 실행
2. `File → Open` → `android` 폴더 선택
3. Gradle 동기화 대기
4. `Build → Make Project` (Ctrl+F9)
5. Gradle 탭에서 `:app → Tasks → build → assembleDebug` 실행

### 4. APK 위치

```
android/app/build/outputs/apk/debug/app-debug.apk
```

## 📲 설치

1. APK를 안드로이드 기기로 전송
2. 파일 탐색기에서 APK 실행
3. "출처를 알 수 없는 앱 설치" 허용
4. 설치 완료

## 🔧 개발

### 개발 서버 실행

```bash
bun run dev
```

### 웹 앱 수정 후 동기화

```bash
bun run build
bunx cap sync android
```

### 안드로이드 프로젝트 열기

```bash
bunx cap open android
```

## 🔄 앱 업데이트

웹사이트(chat.z.ai)가 업데이트되면 앱을 다시 빌드할 필요가 없습니다. 앱은 자동으로 최신 버전의 웹사이트를 로드합니다.

## 📋 권한

| 권한 | 용도 |
|------|------|
| INTERNET | 웹사이트 접속 |
| CAMERA | 카메라 사용 (선택) |
| RECORD_AUDIO | 음성 입력 (선택) |
| POST_NOTIFICATIONS | 알림 (Android 13+) |
| READ_MEDIA_* | 미디어 파일 접근 (Android 13+) |

## 🐛 문제 해결

### Gradle 동기화 실패

- JDK 17 이상 사용 확인
- `android/.gradle` 폴더 삭제 후 재시도

### 웹페이지 로드 안 됨

- 인터넷 연결 확인
- chat.z.ai 접속 가능 여부 확인

### 권한 문제

- 앱 설정에서 카메라/마이크 권한 수동 허용

## 📄 라이선스

MIT License

## 🔗 링크

- [chat.z.ai](https://chat.z.ai)
- [Capacitor 공식 문서](https://capacitorjs.com/docs)
- [Next.js 공식 문서](https://nextjs.org/docs)

---

## 🌐 GitHub Pages 설정

### 1. GitHub Pages 활성화

1. 저장소 Settings → Pages
2. Source: "Deploy from a branch"
3. Branch: `main` 선택
4. Folder: `/docs` 선택
5. Save

### 2. APK 배포 방법

```bash
# 1. APK 빌드 (로컬)
bun run build && bunx cap sync android
cd android && ./gradlew assembleDebug

# 2. APK 파일명 변경
cp app/build/outputs/apk/debug/app-debug.apk ../releases/z-ai-chat-v1.0.0.apk

# 3. Git 태그 및 릴리즈 생성
git tag v1.0.0
git push origin v1.0.0

# 4. GitHub Release 생성
#    - Releases → Draft a new release
#    - Tag: v1.0.0
#    - Title: Z.AI WebView v1.0.0
#    - Attach: releases/z-ai-chat-v1.0.0.apk
```

### 3. 다운로드 링크

GitHub Release APK 직접 링크 형식:
```
https://github.com/haseo-ai/z-ai-chat/releases/download/v1.0.0/z-ai-chat.apk
```

최신 버전 링크:
```
https://github.com/haseo-ai/z-ai-chat/releases/latest
```

---

## ⚖️ 면책 조항

- 이 앱은 **개인 개발자**가 필요에 의해 제작한 비공식 프로젝트입니다.
- chat.z.ai 서비스와 **어떤 공식적인 관계도 없습니다**.
- 모든 데이터 처리는 chat.z.ai 서버에서 이루어지며, 개발자는 데이터를 수집하지 않습니다.
- 서비스 변경, 중단 등에 대한 책임은 사용자 본인에게 있습니다.
- 이 프로젝트는 언제든지 중단되거나 변경될 수 있습니다.
