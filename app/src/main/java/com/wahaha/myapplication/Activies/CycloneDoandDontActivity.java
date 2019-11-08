package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.wahaha.myapplication.R;


public class CycloneDoandDontActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclone_doanddont);

        getSupportActionBar().hide();

        ViewPager viewPager = findViewById(R.id.cyc_viewpager);
        CycloneAdapter adapter = new CycloneAdapter(this);
        viewPager.setAdapter(adapter);



    }
}

