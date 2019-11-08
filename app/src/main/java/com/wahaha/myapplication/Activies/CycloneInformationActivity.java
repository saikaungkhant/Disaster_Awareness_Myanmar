package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wahaha.myapplication.R;

public class CycloneInformationActivity extends AppCompatActivity {

    Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclone_info);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("ဆိုင်ကလုန်းမုန်တိုင်းဆိုင်ရာ အသိပညာပေး");
    }
}
