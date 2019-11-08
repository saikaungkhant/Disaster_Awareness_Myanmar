package com.wahaha.myapplication.Activies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.wahaha.myapplication.R;

public class CycloneHistoryActivity extends AppCompatActivity {

    Toolbar mActionBarToolbar;
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cyclone_history);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("ဘေးအန္တရာယ်ဖြစ်ခဲ့သောမှတ်တမ်းများ");

        c1 = (CardView)findViewById(R.id.c1);
        c2 = (CardView)findViewById(R.id.c2);
        c3 = (CardView)findViewById(R.id.c3);
        c4 = (CardView)findViewById(R.id.c4);
        c5 = (CardView)findViewById(R.id.c5);
        c6 = (CardView)findViewById(R.id.c6);
        c7 = (CardView)findViewById(R.id.c7);
        c8 = (CardView)findViewById(R.id.c8);
        c9 = (CardView)findViewById(R.id.c9);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://my.wikipedia.org/wiki/%E1%80%99%E1%80%AD%E1%80%AF%E1%80%9B%E1%80%AC%E1%80%99%E1%80%AF%E1%80%94%E1%80%BA%E1%80%90%E1%80%AD%E1%80%AF%E1%80%84%E1%80%BA%E1%80%B8");
                startActivity(i);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/2017_North_Indian_Ocean_cyclone_season#Cyclone_Maarutha");
                startActivity(i);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/2016_North_Indian_Ocean_cyclone_season#Cyclone_Kyant");
                startActivity(i);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/Cyclone_Komen");
                startActivity(i);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/Cyclone_Phailin");
                startActivity(i);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://my.wikipedia.org/wiki/%E1%80%82%E1%80%AE%E1%80%9B%E1%80%AD_%E1%80%86%E1%80%AD%E1%80%AF%E1%80%84%E1%80%BA%E1%80%80%E1%80%9C%E1%80%AF%E1%80%94%E1%80%BA%E1%80%B8_%E1%80%99%E1%80%AF%E1%80%94%E1%80%BA%E1%80%90%E1%80%AD%E1%80%AF%E1%80%84%E1%80%BA%E1%80%B8");
                startActivity(i);
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://my.wikipedia.org/wiki/%E1%80%94%E1%80%AC%E1%80%82%E1%80%85%E1%80%BA%E1%80%99%E1%80%AF%E1%80%94%E1%80%BA%E1%80%90%E1%80%AD%E1%80%AF%E1%80%84%E1%80%BA%E1%80%B8");
                startActivity(i);
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/Cyclone_Akash");
                startActivity(i);
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CycloneHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/Cyclone_Mala");
                startActivity(i);
            }
        });

    }
}
