package com.zai.chat;

import android.os.Bundle;
import androidx.core.view.WindowCompat;

import com.getcapacitor.BridgeActivity;
import io.capawesome.capacitor.plugins.edge_to_edge_support.EdgeToEdgeSupportPlugin;

public class MainActivity extends BridgeActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Edge-to-Edge 플러그인 초기화 전에 설정
        registerPlugin(EdgeToEdgeSupportPlugin.class);
        
        super.onCreate(savedInstanceState);
    }
}
