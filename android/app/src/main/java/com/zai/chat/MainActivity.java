package com.zai.chat;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.WindowCompat;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Edge-to-Edge 활성화
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        super.onCreate(savedInstanceState);
        
        // contentView에 40px 패딩 적용
        applyPadding();
    }
    
    private void applyPadding() {
        View contentView = findViewById(android.R.id.content);
        if (contentView != null) {
            // 40dp로 패딩 적용
            int paddingPx = (int) (40 * getResources().getDisplayMetrics().density);
            contentView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);
        }
    }
}
