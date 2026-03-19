package com.zai.chat;

import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.WindowCompat;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Edge-to-Edge 활성화
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        super.onCreate(savedInstanceState);
        
        // 최소 패딩 적용 (1px)
        applyMinimalPadding();
    }
    
    private void applyMinimalPadding() {
        View contentView = findViewById(android.R.id.content);
        if (contentView == null) return;
        
        ViewCompat.setOnApplyWindowInsetsListener(contentView, (v, insets) -> {
            // 1px 패딩
            v.setPadding(1, 1, 1, 1);
            return insets;
        });
    }
}
