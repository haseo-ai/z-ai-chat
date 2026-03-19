# Z AI Chat

[한국어](README.md) | [English](README_EN.md) | [中文](README_ZH.md)

---

将 chat.z.ai 封装为 Android 应用的 Capacitor WebView 应用。

## 📱 项目信息

| 项目 | 值 |
|------|-----|
| 应用名称 | Z AI Chat |
| 包名 | com.zai.chat |
| 最低版本 | Android 12 (API 31) |
| 目标版本 | Android 15 (API 35) |
| 网站 | https://chat.z.ai |

## 🛠 技术栈

- **前端**: Next.js 16 + React 19 + TypeScript
- **样式**: Tailwind CSS 4 + shadcn/ui
- **移动端**: Capacitor 8
- **平台**: Android (Gradle 8.14, AGP 8.5.2)

## 📂 项目结构

```
├── android/                 # Android 原生项目
│   ├── app/
│   │   ├── src/main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── assets/public/   # Web 应用文件
│   │   │   └── res/             # 资源文件
│   │   └── build.gradle
│   ├── build.gradle
│   ├── variables.gradle
│   └── settings.gradle
├── src/app/                 # Next.js Web 应用
│   ├── page.tsx
│   ├── layout.tsx
│   └── globals.css
├── public/
│   ├── icons/               # 应用图标
│   └── manifest.json        # PWA 清单
├── capacitor.config.ts      # Capacitor 配置
├── next.config.ts
└── package.json
```

## 🚀 APK 构建

### 环境要求

- Android Studio (建议 Panda2 或更新版本)
- JDK 17+
- Node.js 18+ & Bun

### 1. 构建 Web 应用

```bash
bun install
bun run build
```

### 2. 同步 Capacitor

```bash
bunx cap sync android
```

### 3. 在 Android Studio 中构建

1. 启动 Android Studio
2. `File → Open` → 选择 `android` 文件夹
3. 等待 Gradle 同步完成
4. `Build → Make Project` (Ctrl+F9)
5. 在 Gradle 标签页运行 `:app → Tasks → build → assembleDebug`

### 4. APK 位置

```
android/app/build/outputs/apk/debug/app-debug.apk
```

## 📲 安装

1. 将 APK 传输到 Android 设备
2. 在文件管理器中打开 APK
3. 允许"安装未知来源应用"
4. 安装完成

## 🔧 开发

### 运行开发服务器

```bash
bun run dev
```

### Web 应用修改后同步

```bash
bun run build
bunx cap sync android
```

### 打开 Android 项目

```bash
bunx cap open android
```

## 🔄 应用更新

当网站 (chat.z.ai) 更新时，无需重新构建应用。应用会自动加载最新版本的网站。

## 📋 权限

| 权限 | 用途 |
|------|------|
| INTERNET | 网站访问 |
| CAMERA | 相机使用 (可选) |
| RECORD_AUDIO | 语音输入 (可选) |
| POST_NOTIFICATIONS | 通知 (Android 13+) |
| READ_MEDIA_* | 媒体文件访问 (Android 13+) |

## 🐛 故障排除

### Gradle 同步失败

- 确认已安装 JDK 17+
- 删除 `android/.gradle` 文件夹后重试

### 网页无法加载

- 检查网络连接
- 确认 chat.z.ai 可访问

### 权限问题

- 在应用设置中手动授予相机/麦克风权限

## 📄 许可证

MIT License

## 🔗 链接

- [chat.z.ai](https://chat.z.ai)
- [Capacitor 文档](https://capacitorjs.com/docs)
- [Next.js 文档](https://nextjs.org/docs)
