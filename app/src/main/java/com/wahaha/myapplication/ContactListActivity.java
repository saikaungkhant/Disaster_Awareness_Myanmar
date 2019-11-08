package com.wahaha.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user1 on 6/25/2019.
 */
public class ContactListActivity extends AppCompatActivity {

    SQLiteDatabase db= SQLiteDatabase.openDatabase("data/data/com.wahaha.myapplication/myContact",null, SQLiteDatabase.CREATE_IF_NECESSARY);;
    String[] items={"dept","phone"};
    String[] tables={"city","name","phone"};

    List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

    int image=R.drawable.p_icon1;

    String deptName,cityName,query,myphone;

    Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlist);

        deptName=getIntent().getStringExtra("Department");
        cityName=getIntent().getStringExtra("City");

        if (deptName.equals("ကယ်ဆယ်ရေး"))
        {
            getSupportActionBar().setTitle(deptName);
            query="select * from saveList";

            cursor=db.rawQuery(query,null);
            int col1=cursor.getColumnIndex("dept");
            int col2=cursor.getColumnIndex("phone");

            if(cursor.getCount()>0)
            {
                while (cursor.moveToNext())
                {
                    items[0]=cursor.getString(col1);
                    items[1]=cursor.getString(col2);

                    HashMap<String, String> hm = new HashMap<String, String>();
                    hm.put("listview_title", items[0]);
                    hm.put("listview_discription", items[1]);
                    hm.put("listview_image", Integer.toString(image));
                    aList.add(hm);
                }
            }
        }
        else if (deptName.equals("ဆေးရုံ") )
        {
            getSupportActionBar().setTitle(deptName);
            selectCity();
        }
        else if (deptName.equals("ရဲစခန်း"))
        {
            getSupportActionBar().setTitle(deptName);
            retrievePolice();
        }
        else if (deptName.equals("မီးသတ်"))
        {
            getSupportActionBar().setTitle(deptName);
            retrieveFire();
        }


        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.contactdetail, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                myphone="tel:"+aList.get(i).get("listview_discription");
                Intent phoneNo=new Intent(Intent.ACTION_DIAL,Uri.parse(myphone));
                startActivity(phoneNo);
            }
        });
    }

    public void selectCity()
    {
        if (cityName.equals("ကချင်"))
        {
            retrieveHospital();
        }
        else if(cityName.equals("ကယား"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("ကရင်"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("ချင်း"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("စစ်ကိုင်း"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("တနင်္သာရီ"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("ပဲခူး"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("မကွေး"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("မန္တလေး"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("မွန်"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("ရခိုင်"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("ရှမ်း"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("ရန်ကုန်"))
        {
            retrieveHospital();
        }
        else if (cityName.equals("ဧရာဝတီ"))
        {
            retrieveHospital();
        }
    }

    public void retrieveHospital()
    {
        getSupportActionBar().setTitle(cityName);
        query="select * from hospital where city='"+cityName+"'";

        cursor=db.rawQuery(query,null);
        int col1=cursor.getColumnIndex("city");
        int col2=cursor.getColumnIndex("name");
        int col3=cursor.getColumnIndex("phone");

        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                tables[0]=cursor.getString(col1);
                tables[1]=cursor.getString(col2);
                tables[2]=cursor.getString(col3);

                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", tables[1]);
                hm.put("listview_discription", tables[2]);
                hm.put("listview_image", Integer.toString(image));
                aList.add(hm);
            }
        }
    }

    public void retrievePolice()
    {
        query="select * from police";

        cursor=db.rawQuery(query,null);
        int col1=cursor.getColumnIndex("city");
        int col2=cursor.getColumnIndex("name");
        int col3=cursor.getColumnIndex("phone");

        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                tables[0]=cursor.getString(col1);
                tables[1]=cursor.getString(col2);
                tables[2]=cursor.getString(col3);

                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", tables[1]);
                hm.put("listview_discription", tables[2]);
                hm.put("listview_image", Integer.toString(image));
                aList.add(hm);
            }
        }
    }

    public void retrieveFire()
    {
        query="select * from fire";

        cursor=db.rawQuery(query,null);
        int col1=cursor.getColumnIndex("city");
        int col2=cursor.getColumnIndex("name");
        int col3=cursor.getColumnIndex("phone");

        if(cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                tables[0]=cursor.getString(col1);
                tables[1]=cursor.getString(col2);
                tables[2]=cursor.getString(col3);

                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", tables[1]);
                hm.put("listview_discription", tables[2]);
                hm.put("listview_image", Integer.toString(image));
                aList.add(hm);
            }
        }
    }

}