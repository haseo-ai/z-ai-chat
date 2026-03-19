package com.zai.chat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.Window;
import androidx.core.view.WindowCompat;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 타이틀 바 제거
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        // Edge-to-Edge 설정 (전체화면)
        setupFullscreen();
        
        super.onCreate(savedInstanceState);
    }
    
    private void setupFullscreen() {
        try {
            // 기본 Edge-to-Edge 설정
            WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
            
            // 안드로이드 11+ (API 30+): WindowInsetsController 사용
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                WindowInsetsController controller = getWindow().getInsetsController();
                if (controller != null) {
                    // 상태바와 네비게이션바 숨기기
                    controller.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                    // 스와이프로 일시 표시
                    controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                }
            }
        } catch (Exception e) {
            // 에러 발생 시 기본 설정으로 진행
            e.printStackTrace();
        }
    }
}
