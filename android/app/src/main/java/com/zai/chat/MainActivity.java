package com.zai.chat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.WindowCompat;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 안드로이드 버전별 Edge-to-Edge 처리
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            // Android 15+ (API 35): Edge-to-Edge 활성화 + 패딩 처리
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        } else {
            // Android 12-14 (API 31-34): Edge-to-Edge 비활성화
            WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        }
        
        super.onCreate(savedInstanceState);
        
        // Android 15+에서만 WindowInsets 패딩 처리
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            setupWindowInsets();
        }
    }
    
    private void setupWindowInsets() {
        View rootView = findViewById(android.R.id.content);
        if (rootView == null) return;
        
        rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                // 시스템 바(상태바, 내비게이션바) 인셋
                int left = insets.getSystemWindowInsetLeft();
                int top = insets.getSystemWindowInsetTop();
                int right = insets.getSystemWindowInsetRight();
                int bottom = insets.getSystemWindowInsetBottom();
                
                // IME (키보드) 인셋
                int imeBottom = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    imeBottom = insets.getInsets(WindowInsets.Type.ime()).bottom;
                }
                
                // Capacitor WebView의 부모 컨테이너에 패딩 적용
                View appView = getBridge().getAppView();
                if (appView != null) {
                    appView.setPadding(left, top, right, Math.max(bottom, imeBottom));
                }
                
                return insets;
            }
        });
    }
}
