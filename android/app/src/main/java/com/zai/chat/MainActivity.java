package com.zai.chat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.view.WindowCompat;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Edge-to-Edge 활성화
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        super.onCreate(savedInstanceState);
        
        // 상태바/네비게이션바 높이만큼 패딩 적용
        applySystemBarPadding();
    }
    
    private void applySystemBarPadding() {
        View rootView = findViewById(android.R.id.content);
        if (rootView == null) return;
        
        rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                // 상태바 높이
                int statusBarHeight = insets.getSystemWindowInsetTop();
                // 네비게이션바 높이
                int navigationBarHeight = insets.getSystemWindowInsetBottom();
                // 좌우 인셋 (노치 등)
                int left = insets.getSystemWindowInsetLeft();
                int right = insets.getSystemWindowInsetRight();
                
                // WebView 찾아서 패딩 적용
                WebView webView = findWebView(rootView);
                if (webView != null) {
                    webView.setPadding(left, statusBarHeight, right, navigationBarHeight);
                }
                
                return insets;
            }
        });
    }
    
    private WebView findWebView(View view) {
        if (view instanceof WebView) {
            return (WebView) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                WebView found = findWebView(group.getChildAt(i));
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
