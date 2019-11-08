package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.wahaha.myapplication.R;

public class LandslideDoandDontActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land_doanddont);
        ViewPager viewPager = findViewById(R.id.land_viewpager);
        LandslideAdapter adapter = new LandslideAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
