package com.certination.hackethon;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;

public class SplashTest extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get instance of Vibrator from current Context
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

// Vibrate for 400 milliseconds
        v.vibrate(6000);

       /* requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_test);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

                SplashTest.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out_2);

            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
