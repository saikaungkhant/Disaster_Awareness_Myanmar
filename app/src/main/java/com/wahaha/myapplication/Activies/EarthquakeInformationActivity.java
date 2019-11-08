package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wahaha.myapplication.R;

public class EarthquakeInformationActivity extends AppCompatActivity {

    Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_info);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("မြေငလျှင်ဆိုင်ရာ အသိပညာပေး");
    }
}
