package com.zai.chat;

import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    
    private View contentView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Edge-to-Edge 활성화
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        super.onCreate(savedInstanceState);
        
        // 시스템 바 높이만큼 패딩 적용
        applySystemBarPadding();
    }
    
    private void applySystemBarPadding() {
        contentView = findViewById(android.R.id.content);
        if (contentView == null) return;
        
        ViewCompat.setOnApplyWindowInsetsListener(contentView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            
            // 시스템 바 높이의 2배만큼 패딩 적용
            int topPadding = systemBars.top * 2;
            int bottomPadding = systemBars.bottom * 2;
            int leftPadding = systemBars.left * 2;
            int rightPadding = systemBars.right * 2;
            
            v.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
            
            return insets;
        });
    }
}
