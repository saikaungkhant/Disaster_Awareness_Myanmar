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

public class CycloneActivity extends AppCompatActivity {


    Toolbar mActionBarToolbar;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstcyclone);


        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbarcyc);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("ဆိုင်ကလုန်း မုန်တိုင်း");

        listView = (ListView) findViewById(R.id.cyclone_first);
        String[] values = new String[]{"ဆိုင်ကလုန်းမုန်တိုင်းဆိုင်ရာ အသိပညာပေး","ဘေးအန္တရာယ်ဖြစ်ခဲ့သောမှတ်တမ်းများ","ဆောင်ရန်ရှောင်ရန်များ","အသိပညာပေး ဗီဒီယို"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Intent intent = new Intent(view.getContext(),CycloneInformationActivity.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(view.getContext(),CycloneHistoryActivity.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(view.getContext(),CycloneDoandDontActivity.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(view.getContext(),CycloneVideoActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
