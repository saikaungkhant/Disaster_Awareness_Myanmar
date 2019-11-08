package com.wahaha.myapplication.Activies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.wahaha.myapplication.R;

public class EarthquakeHistoryActivity extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;
    Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_history);
        c1 = (CardView)findViewById(R.id.c1);
        c2 = (CardView)findViewById(R.id.c2);
        c3 = (CardView)findViewById(R.id.c3);
        c4 = (CardView)findViewById(R.id.c4);
        c5 = (CardView)findViewById(R.id.c5);
        c6 = (CardView)findViewById(R.id.c6);
        c7 = (CardView)findViewById(R.id.c7);
        c8 = (CardView)findViewById(R.id.c8);
        c9 = (CardView)findViewById(R.id.c9);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("ဘေးအန္တရာယ်ဖြစ်ခဲ့သောမှတ်တမ်းများ");

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://my.wikipedia.org/wiki/%E1%81%82%E1%81%80%E1%81%81%E1%81%86_%E1%80%A9%E1%80%82%E1%80%AF%E1%80%90%E1%80%BA_%E1%80%99%E1%80%BC%E1%80%94%E1%80%BA%E1%80%99%E1%80%AC%E1%80%84%E1%80%9C%E1%80%BB%E1%80%84%E1%80%BA");
                startActivity(i);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://my.wikipedia.org/wiki/%E1%81%82%E1%81%80%E1%81%81%E1%81%86_%E1%80%A7%E1%80%95%E1%80%BC%E1%80%AE_%E1%80%99%E1%80%BC%E1%80%94%E1%80%BA%E1%80%99%E1%80%AC%E1%80%84%E1%80%9C%E1%80%BB%E1%80%84%E1%80%BA");
                startActivity(i);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://my.wikipedia.org/wiki/%E1%81%82%E1%81%80%E1%81%81%E1%81%82_%E1%80%9B%E1%80%BD%E1%80%BE%E1%80%B1%E1%80%98%E1%80%AD%E1%80%AF_%E1%80%84%E1%80%9C%E1%80%BB%E1%80%84%E1%80%BA");
                startActivity(i);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://my.wikipedia.org/wiki/%E1%81%82%E1%81%80%E1%81%81%E1%81%81_%E1%80%99%E1%80%BC%E1%80%94%E1%80%BA%E1%80%99%E1%80%AC_%E1%80%84%E1%80%9C%E1%80%BB%E1%80%84%E1%80%BA");
                startActivity(i);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/1975_Bagan_earthquake");
                startActivity(i);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/1956_Sagaing_earthquake");
                startActivity(i);
            }
        });

        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/1931_Myitkyina_earthquake");
                startActivity(i);
            }
        });

        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EarthquakeHistoryActivity.this,WebviewActivity.class);
                i.putExtra("url","https://en.wikipedia.org/wiki/1762_Arakan_earthquake");
                startActivity(i);
            }
        });



    }
}
