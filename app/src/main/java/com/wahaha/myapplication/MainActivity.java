package com.wahaha.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.wahaha.myapplication.Activies.FirebaseMapsViewActivity;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000; //splash screen will be shown for 2 seconds

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(MainActivity.this, FirebaseMapsViewActivity.class);
                startActivity(mainIntent);
                customType(MainActivity.this, "fadein-to-fadeout");
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}
