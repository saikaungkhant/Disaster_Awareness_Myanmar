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

public class FloodActivity extends AppCompatActivity {

    Toolbar mActionBarToolbar;

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstflood);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("ရေကြီး ရေလျှံ ဘေး");

        listView = (ListView) findViewById(R.id.flood_first);
        String[] values = new String[]{"ရေကြီးချင်းဆိုင်ရာ အသိပညာပေး","ဘေးအန္တရာယ် သတင်းအချက်အလက်","ဆောင်ရန်ရှောင်ရန်များ","အသိပညာပေး ဗီဒီယို"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Intent intent = new Intent(view.getContext(),FloodInformationActivity.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(view.getContext(),FloodHistoryActivity.class);
                    intent.putExtra("url","https://www.myanmarwaterportal.com/news/myanmar-water-journal.html");
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(view.getContext(),FloodDoandDontActivity.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(view.getContext(),FloodVideoActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
