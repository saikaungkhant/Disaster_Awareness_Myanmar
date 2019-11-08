package com.wahaha.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by user1 on 7/2/2019.
 */
public class CityListActivity extends AppCompatActivity {

    String[] city={"ကချင်","ကယား","ကရင်","ချင်း","စစ်ကိုင်း","တနင်္သာရီ","ပဲခူး","မကွေး","မန္တလေး","မွန်","ရခိုင်","ရှမ်း","ရန်ကုန်","ဧရာဝတီ"};

    int cityImage=R.drawable.city;

    ArrayList arrayList=new ArrayList();
    ListView cityList;
    String dept;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citylist);

        dept=getIntent().getStringExtra("Department");
        getSupportActionBar().setTitle(dept);

        cityList=(ListView)findViewById(R.id.cityList);

        for(int i=0;i<city.length;i++)
        {
            arrayList.add(new Item(city[i],cityImage));
        }

        CityAdapter adapter=new CityAdapter(this,R.layout.citydetail,arrayList);
        cityList.setAdapter(adapter);

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String chooseCity=city[i].toString();
                Intent contactIntent=new Intent(CityListActivity.this,ContactListActivity.class);
                contactIntent.putExtra("City",chooseCity);
                contactIntent.putExtra("Department",dept);
                startActivity(contactIntent);
            }
        });

    }

    public class CityAdapter extends ArrayAdapter
    {
        ArrayList array = new ArrayList<>();

        public CityAdapter(Context context, int textViewResourceId, ArrayList objects)
        {
            super(context, textViewResourceId, objects);
            array = objects;
        }

        @Override
        public int getCount()
        {
            return super.getCount();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.citydetail,null);
            TextView textView = (TextView) view.findViewById(R.id.textView);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            textView.setText(((Item)array.get(position)).getitemName());
            imageView.setImageResource(((Item)array.get(position)).getitemImage());
            return view;

        }
    }
}
