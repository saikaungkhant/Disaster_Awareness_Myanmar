package com.wahaha.myapplication.Activies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wahaha.myapplication.R;

public class LandslideActivity extends AppCompatActivity {

    Toolbar mActionBarToolbar;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstland);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("မြေပြိုဘေး");

        listView = (ListView) findViewById(R.id.land_first);
        String[] values = new String[]{"မြေပြိုခြင်းဆိုင်ရာ အသိပညာပေး","မြေပြိုရခြင်း အကြောင်းအရင်းများ","ဆောင်ရန်ရှောင်ရန်များ","အသိပညာပေး ဗီဒီယို"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Intent intent = new Intent(view.getContext(),LandslideInformationActivity.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(view.getContext(),LandslideHistoryActivity.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(view.getContext(),LandslideDoandDontActivity.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(view.getContext(),LandslideVideoActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
