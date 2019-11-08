package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.wahaha.myapplication.R;

public class FloodDoandDontActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flood_doanddont);

        ViewPager viewPager = findViewById(R.id.flood_viewpager);
        CycloneAdapter adapter = new CycloneAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
