import type { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.zai.chat',
  appName: 'Z.AI',
  webDir: 'out',
  server: {
    // 직접 chat.z.ai 로드 (iframe 차단 문제 해결)
    url: 'https://chat.z.ai',
    cleartext: true,
  },
  android: {
    backgroundColor: '#ffffff',
    buildOptions: {
      keystorePath: undefined,
      keystorePassword: undefined,
      keystoreAlias: undefined,
      keystoreAliasPassword: undefined,
      signingType: 'apksigner',
    },
  },
  plugins: {
    SplashScreen: {
      launchShowDuration: 500,
      backgroundColor: '#ffffff',
      androidSplashResourceName: 'splash',
      androidScaleType: 'CENTER_CROP',
      showSpinner: false,
    },
    EdgeToEdgeSupport: {
      // 상태바와 네비게이션바 투명하게
      statusBarStyle: 'LIGHT',
      navigationBarStyle: 'LIGHT',
      statusBarBackgroundColor: '#00000000',
      navigationBarBackgroundColor: '#00000000',
    },
  },
};

export default config;
