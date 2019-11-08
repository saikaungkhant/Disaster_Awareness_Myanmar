package com.wahaha.myapplication.Activies;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.wahaha.myapplication.R;

public class DroughtDoandDontActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drought_doanddont);

        ViewPager viewPager = findViewById(R.id.drought_viewpager);
        DroughAdapter adapter = new DroughAdapter(this);
        viewPager.setAdapter(adapter);



    }
}
