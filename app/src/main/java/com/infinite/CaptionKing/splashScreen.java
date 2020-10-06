package com.infinite.CaptionKing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
        setContentView(R.layout.activity_splash_screen);





        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(splashScreen.this, MainActivity.class);

                startActivity(i);

                // close this activity

                finish();

            }

        },2 *1000); // wait for 2 seconds
    }
}
