package com.zai.chat;

import android.os.Bundle;
import android.view.View;
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
        
        // contentView에 10px 패딩
        applyContentPadding();
        
        // WebView에 20px 패딩
        applyWebViewPadding();
    }
    
    private void applyContentPadding() {
        View contentView = findViewById(android.R.id.content);
        if (contentView != null) {
            int paddingPx = (int) (10 * getResources().getDisplayMetrics().density);
            contentView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);
        }
    }
    
    private void applyWebViewPadding() {
        View contentView = findViewById(android.R.id.content);
        if (contentView != null) {
            WebView webView = findWebView(contentView);
            if (webView != null) {
                int paddingPx = (int) (20 * getResources().getDisplayMetrics().density);
                webView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);
            }
        }
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
