package com.example.holideys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashClass extends Activity {
    private final int SPLAHS_DISPLAY_LENGHT = 5000;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashClass.this,MainActivity.class);
                SplashClass.this.startActivities(new Intent[]{intent});
                SplashClass.this.finish();
            }
        },SPLAHS_DISPLAY_LENGHT);



    }


}
