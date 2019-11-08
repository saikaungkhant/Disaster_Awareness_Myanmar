package com.wahaha.myapplication.Activies;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.wahaha.myapplication.CityListActivity;
import com.wahaha.myapplication.ContactListActivity;
import com.wahaha.myapplication.Item;
import com.wahaha.myapplication.R;

import java.util.ArrayList;

public class EmergencyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SQLiteDatabase db;
    GridView grid;
    ArrayList arrayList=new ArrayList<>();

    String[] department={"ကယ်ဆယ်ရေး","ဆေးရုံ","ရဲစခန်း","မီးသတ်"};

    int[] image={R.drawable.mswrr,R.drawable.hospital,R.drawable.police,R.drawable.fire};

    String selected_dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nav_emergency);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle("အရေးပေါ် ဖုန်းနံပတ်များ");

        grid=(GridView)findViewById(R.id.grid);

        for (int i=0;i<4;i++)
        {
            arrayList.add(new Item(department[i],image[i]));
        }

        MyAdapter adapter=new MyAdapter(this,R.layout.gridview,arrayList);
        Log.d("asdfsaf", adapter.array.size()+"");
        grid.setAdapter(adapter);



        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                selected_dept=department[i].toString();

                if (selected_dept.equals("ဆေးရုံ"))
                {
                    Intent citylist=new Intent(EmergencyActivity.this, CityListActivity.class);
                    citylist.putExtra("Department",selected_dept);
                    startActivity(citylist);
                }
                else
                {
                    Intent save=new Intent(EmergencyActivity.this, ContactListActivity.class);
                    save.putExtra("Department",selected_dept);
                    startActivity(save);
                }

            }
        });

        createTable();
        deleteTable();
        insertTable();

    }

    private void createTable()
    {
        db= SQLiteDatabase.openDatabase("data/data/com.wahaha.myapplication/myContact",null, SQLiteDatabase.CREATE_IF_NECESSARY);
        System.out.print("Db created.");
        db.beginTransaction();
        try{
            db.execSQL("create table saveList ("
                    + "cID integer PRIMARY KEY AUTOINCREMENT, "
                    + "dept text, "
                    + "phone text);");


            db.execSQL("create table hospital ("
                    + "hID integer PRIMARY KEY AUTOINCREMENT, "
                    + "city text, "
                    + "name text, "
                    + "phone text);");


            db.execSQL("create table police ("
                    + "pID integer PRIMARY KEY AUTOINCREMENT, "
                    + "city text, "
                    + "name text, "
                    + "phone text);");


            db.execSQL("create table fire ("
                    + "fID integer PRIMARY KEY AUTOINCREMENT, "
                    + "city text, "
                    + "name text, "
                    + "phone text);");
            db.setTransactionSuccessful();

           // Toast.makeText(this, "All Table are created", Toast.LENGTH_SHORT).show();

        }catch (SQLiteException e){
            //Toast.makeText(this, "Table already created", Toast.LENGTH_SHORT).show();

        }finally {
            db.endTransaction();
        }
    }

    public void insertTable()
    {
        db.beginTransaction();

        try {

            //insert into save
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူးချုပ်','067-404050');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူးချုပ်','067-404048');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(စီမံဘဏ္ဍာ)','067-404316');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(ကယ်ဆယ်ရေး)','067-404318');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(ပြန်/ထူ)','067-404317');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(ညှိ/သု)','067-404485');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး(စီမံဘဏ္ဍာ)','067-404046');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး(ကယ်ဆယ်ရေး)','067-404420');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး(ပြန်/ထူ)်','067-404369');");
            db.execSQL("insert into saveList (dept,phone) values('စီမံဌာန်','067-404113');");
            db.execSQL("insert into saveList (dept,phone) values('ဘဏ္ဍာဌာန','067-404047');");
            db.execSQL("insert into saveList (dept,phone) values('ကယ်ဆယ်ရေးဌာန','067-404114');");
            db.execSQL("insert into saveList (dept,phone) values('ပြန်လည်ထူထောင်ရေးဌာန','067-404369');");
            db.execSQL("insert into saveList (dept,phone) values('ညှိနှိုင်းဆောင်ရွက်ရေးနှင့် သုတေသန ဌာန','067-404049');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူးချုပ်','067-404032');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူးချုပ်','067-404103');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(စီမံ/ဘဏ္ဍာ)','067-404179');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(ကလေး/လူငယ်)','067-404379');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(ပြည်/စီ)','067-404373');");
            db.execSQL("insert into saveList (dept,phone) values('ညွှန်ကြားရေးမှူး(ပြန်/ထူ)','067-404378');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး(စီမံ)','067-404102');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး(ဘဏ္ဍာ)','067-404371');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး(ကလေး)','067-404112');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး(လူငယ်)','067-404112');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး (နိုင်ငံတကာဆက်ဆံရေး)','067-404370');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး (စီမံကိန်းနှင့် စာရင်းအင်း)','067-404292');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး (မသန်/ပြန်ထူ)','067-404294');");
            db.execSQL("insert into saveList (dept,phone) values('ဒုတိယညွှန်ကြားရေးမှူး (မကျောင်း/မရေးရာ)','067-404101');");


            //insert into hospital
            db.execSQL("insert into hospital (city,name,phone) values('ကချင်','မြစ်ကြီးနားပြည်သူ့ဆေးရုံ','074 22 501');");
            db.execSQL("insert into hospital (city,name,phone) values('ကချင်','မြတ်မွန်ဆေးရုံ','09 240 1034');");
            db.execSQL("insert into hospital (city,name,phone) values('ကချင်','မြစ်ကြီးနာမူးယစ်ဆေးဝါးဆေးရုံ','074 22 428');");
            db.execSQL("insert into hospital (city,name,phone) values('ကချင်','စန်းသော်တာပုဂ္ဂလိကဆေးရုံ','074 23 026');");
            db.execSQL("insert into hospital (city,name,phone) values('ကချင်','အေးသုခဆေးရုံ','09 793 805866');");

            db.execSQL("insert into hospital (city,name,phone) values('ကယား','ကယားပြည်သူ့ဆေးရုံ','083 240032');");
            db.execSQL("insert into hospital (city,name,phone) values('ကယား','ဒီးမော့ဆိုတိုင်းရင်းဆေးရုံ','083 40 005');");
            db.execSQL("insert into hospital (city,name,phone) values('ကယား','ရိုးရာဆေးပညာဆေးရုံ','083 222 2249');");

            db.execSQL("insert into hospital (city,name,phone) values('ကရင်','ဘားအံ့အထွေထွေရောဂါကုဆေးရုံကြီး','058 21 251');");
            db.execSQL("insert into hospital (city,name,phone) values('ကရင်','ဇွဲကပင်ဆေးရုံ','09 255 066 431');");
            db.execSQL("insert into hospital (city,name,phone) values('ကရင်','ဗျာဒိတ်ပန်ဆေးရုံ','09 791 584471');");
            db.execSQL("insert into hospital (city,name,phone) values('ကရင်','ကော့ကရိတ်ခရိုင်ပြည်သူ့ဆေးရုံ','09 776 070062');");


            db.execSQL("insert into hospital (city,name,phone) values('ချင်း','ဟားခါးအထွေထွေဆေးရုံကြီး','070 21 021');");
            db.execSQL("insert into hospital (city,name,phone) values('ချင်း','မတူပီအများပြည်သူဆေးရုံ','070 80 009');");
            db.execSQL("insert into hospital (city,name,phone) values('ချင်း','ဝယ်စလီဆေးရုံ','09 5112950');");
            db.execSQL("insert into hospital (city,name,phone) values('ချင်း','တော်ဝင်စီးတီးဆေးရုံ','073 22 816');");
            db.execSQL("insert into hospital (city,name,phone) values('ချင်း','မင်းတပ်ဆေးရုံ','070 80 009');");
            db.execSQL("insert into hospital (city,name,phone) values('ချင်း','မင်းတပ်ဆေးရုံ','070 80 009');");

            db.execSQL("insert into hospital (city,name,phone) values('စစ်ကိုင်း','စစ်ကိုင်းမြို့ ခုတင်(၂၀၀)ဆံ့ အထွေထွေရောဂါကုဆေးရုံ','074 22 501');");
            db.execSQL("insert into hospital (city,name,phone) values('စစ်ကိုင်း','ဦးအေးချမ်းသာဆေးရုံ','09 896 474150');");
            db.execSQL("insert into hospital (city,name,phone) values('စစ်ကိုင်း','ဝယ်စလီဆေးရုံ','09 492 97152');");
            db.execSQL("insert into hospital (city,name,phone) values('စစ်ကိုင်း','ရွှေတော်ဝင်ဆေးရုံ','071 24 045');");
            db.execSQL("insert into hospital (city,name,phone) values('စစ်ကိုင်း','မုံရွာအထွေထွေဆေးရုံကြီး','071 22 750');");
            db.execSQL("insert into hospital (city,name,phone) values('စစ်ကိုင်း','ဇာနီထွန်းဆေးရုံ','09 470 82960');");

            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','တောင်ကြီးအထွေထွေရောဂါကုဆေးရုံကြီးး','081 205 000');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','မြတ်တော်ဝင်ဆေးရုံ','081 205 139');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','ထှန်းဆေးရုံ','081 212 3255');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','ကျိုင်းတုံအထွေထွေရောဂါကုဆေးရုံကြီး','084 21 511');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','စေတနာဆေးရုံ','084 23 334');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','လားရှိုးအထွေထွေဆေးရုံကြီး','09 788 075591');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','အောင်ဆေးရုံ-လားရှိုး','082 220 4134');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','အာယုသုခဆေးရုံ','082 25 803');");
            db.execSQL("insert into hospital (city,name,phone) values('ရှမ်း','လားရှိုးဗဟိုဆေးရုံကြီး','09 44050 4268');");

            db.execSQL("insert into hospital (city,name,phone) values('ရခိုင်','စစ်တွေဆေးရုံကြီးုံ','043 23511');");


            db.execSQL("insert into hospital (city,name,phone) values('ဧရာဝတီ','ပုသိမ်အထွေထွေဆေးရုံကြီးုံ','042 24 378');");
            db.execSQL("insert into hospital (city,name,phone) values('ဧရာဝတီ','ကျိုက်လတ်ဆေးရုံ','09 975 522607');");
            db.execSQL("insert into hospital (city,name,phone) values('ဧရာဝတီ','ဧရာဝတီယူနိုက်တက်ဆေးရုံ(Win Sammering Co.,Ltd.)','042 45 182');");

            db.execSQL("insert into hospital (city,name,phone) values('မကွေး','မကွေး အထွေထွေရောဂါကုဆေးရုံကြီး','063 25 511');");
            db.execSQL("insert into hospital (city,name,phone) values('မကွေး','ကောင်းမွန်ဆေးရုံ','063 23 286');");

            db.execSQL("insert into hospital (city,name,phone) values('ပဲခူး','ပဲခူးပြည်သူ့ဆေးရုံ','052 21 511');");
            db.execSQL("insert into hospital (city,name,phone) values('ပဲခူး','အောင်ဆေးရုံ','09 964 655591');");
            db.execSQL("insert into hospital (city,name,phone) values('ပဲခူး','စွယ်တော်အထူးကုဆေးရုံ','09 770 123411');");

            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','မန္တလေးအထွေထွေရောဂါကုဆေးရုံကြီး','02 21511');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','တက္ကသိုလ်များဆေးရုံ','02 21805');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','မန္တလေးအရိုးအထူးကုဆေးရုံ','02 21805');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','မြတ်သုခဆေးရုံ','02 74823');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','ပန်းလှိုင်ဆေးရုံ','02 4069487');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','နေပြည်တော် အထွေထွေရောဂါကုဆေးရုံကြီး','067 420 096');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','ဘောဂသိဒ္ဓိဆေးရုံ','067 432 361');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','ကောင်းသစ်ဆေးရုံ','067  432 358');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','သုခဝတီဆေးရုံ','067 810 8353');");
            db.execSQL("insert into hospital (city,name,phone) values('မန္တလေး','မေမေဆေးရုံ','09 762 191272');");

            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရန်ကုန်အထွေထွေရောဂါကုဆေးရုံကြီး','01 256 112');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','အထွေထွေရောဂါကု ဆေးရုံသစ်ကြီး','01 384 493');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရန်ကုန် အရှေ့ပိုင်း ဆေးရုံ','01 292 835');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရန်ကုန် အနောက်ပိုင်း ဆေးရုံ','01 222 860');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရန်ကုန် ဗဟို အမျိုးသမီး ဆေးရုံ','01 222 811');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရန်ကုန်ကလေးဆေးရုံကြီး','01 222 807');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရန်ကုန် နား နှာခေါင်း လည်ချောင်း ဆေးရုံ','01 544 000');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','အလုပ်သမား ဆေးရုံကြီး (ရန်ကုန်)','01 554 455');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','မြောက်ဥက္ကလာပအထွေထွေဆေးရုံကြီး','01 969 9422');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','တောင်ဥက္ကလာပ မိခင်နှင့်ကလေး အထူးကုဆေးရုံ','01 562 522');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','သင်္ဃန်းကျွန်း စံပြ ဆေးရုံ','01 579 890');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရွာသာကြီး စိတ်ကျန်းမာရေး ဆေးရုံကြီး','01 585 197');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','အင်းစိန်ဆေးရုံ','01 640 132');");

            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','အကယ်ဒမီဆေးရုံ','01 212 886');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','အာယုအပြည်ပြည်ဆိုင်ရာဆေးရုံ','01 212 886');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','အောင်ရတနာဆေးရုံ','01 855 1355');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ဗဟိုစည်ဆေးရုံ','01 230 0631');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ဆာကူရာဆေးရုံ','01 512 668');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရွှေဂုံတိုင်အထူးကုစင်တာ (SSC)','01 860 3618');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ပန်းလှိုင်နိုင်ငံတကာဆေးရုံ','01 684323');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','သုခကမ္ဘာ','01 500 655');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','အာရှတော်ဝင် အထွေထွေရောဂါကုဆေးရုံကြီး','01 538055');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ရွှေဂုံတိုင်အထူးကုဆေးရုံ','01 544116');");
            db.execSQL("insert into hospital (city,name,phone) values('ရန်ကုန်','ပါရမိအထွေထွေကုဆေးရုံ','01 651 674');");

            db.execSQL("insert into hospital (city,name,phone) values('မွန်','မော်လမြိုင် အထွေထွေရောဂါကုဆေးရုံကြီး','057 20 111');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','မော်လမြိုင်ကယ်ဆယ်ရေး','09 785 785199');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','ကျိုက်ထိုမြို့နယ်ဆေးရုံ','057 60 008');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','မုဒုံပြည်သူ့ဆေးရုံ','057 70 025');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','သံဖြူဇရပ်ဆေးရုံ','057 79 361');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','သထုံခရိုင်ဆေးရုံ','057 40 051');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','ချောင်းဆုံမြို့နယ်ဆေးရုံ','09 44116 1402');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','ငွေမိုးဆေးရုံ','057 26 703');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','ရတနာမွန်ဆေးရုံ','057 22 816');");
            db.execSQL("insert into hospital (city,name,phone) values('မွန်','ရွှေလမင်းဆေးရုံ','057 202 6202');");

            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','ကော့သောင်းအထွေထွေဆေးရုံကြီး','059-111111');");
            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','ထားဝယ်ပြည်သူ့ဆေးရုံ','059 24 000');");
            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','မြိတ်အများပိုင်ဆေးရုံ','059 42 033');");
            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','မြိတ် - ကလေးဆေးရုံ','059-111111');");
            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','ရေးမြို့နယ်ဆေးရုံုံ','09782087084');");
            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','ဒက္ခိဏဒီပါ ဆေးရုံကြီး','059 41 824');");
            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','မြင့်မိုဦးပုဂ္ဂလိကဆေးရုံ','09 781 762094');");
            db.execSQL("insert into hospital (city,name,phone) values('တနင်္သာရီ','တော်ဝင်ဆေးရုံ','059 41 171');");


            //insert into police
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','Hotline','199');");
            db.execSQL("insert into police (city,name,phone) values('ကချင်','မြစ်ကြီးနားမြို့နယ်ရဲတပ်ဖွဲ့ရုံး','074 22 077');");
            db.execSQL("insert into police (city,name,phone) values('စစ်ကိုင်း','စစ်ကိုင်းမြို့နယ်ရဲတပ်ဖွဲ့ရုံး','074 22 501');");
            db.execSQL("insert into police (city,name,phone) values('မန္တလေး','မန္တလေး - အမှတ် (8), ရဲတပ်ဖွဲ့စခန်း','02 36 994');");
            db.execSQL("insert into police (city,name,phone) values('မန္တလေး','မန္တလေး - အမှတ် (5) ရဲတပ်ဖွဲ့စခန်း','02 403 6991');");
            db.execSQL("insert into police (city,name,phone) values('မန္တလေး','မန္တလေး - အမရပူရရဲတပ်ဖွဲ့စခန်း','02 407 0998');");
            db.execSQL("insert into police (city,name,phone) values('ရှမ်း','ကျိုင်းတုံရဲစခန်း','084 21 000');");

            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - အလုံ','01-220793');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဗဟန်း','01-554630');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဘုရင့်နောင်','01-680774');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - အရှေ့ဒဂုံ','01-585187');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - မြောက်ဒဂုံ','01-584109');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - တောင်ဒဂုံ','01-590093');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဒဂုံဆိပ်ကမ်း','01-593007');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဒဂုံ','01-374427');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဒေါပုံ','01-556988');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - လှိုင်သာယာ','01-645015');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - လှိုင်','01-519531');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ထောက်ကြံ့','01-600032');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - အင်းစိန်','01-645821');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ကမာရွတ်','01-536895');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ကျောက်တံတား','01-371054');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ကြည့်မြင်တိုင်','01-535867');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - လမ်းမတော်','01-224528');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - လသာ','01-253202');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - မရမ်းကုန်း','01-660352');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - မင်္ဂလာတောင်ညွန့်','01-291034');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - မင်္ဂလာဒုံ','01-635074');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ပန်းပဲတန်း','01-371398');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ပုစွန်တောင်','01-291218');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - တောင်ဥက္ကလာပ','01-561642');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - စမ်းချောင်း','01-535184');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ရွှေပေါက်ကံ','01-695561');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ရွှေပြည်သာ','01-610667');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - တာမွေ','01-556771');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - သာကေတ','01-556865');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - သင်္ဃန်းကျွန်း','01-562544');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - သုဝဏ္ဏ','01-562588');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဝေဘာဂီ','01-9699138');");
            db.execSQL("insert into police (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ရန်ကင်း','01-577190');");

            //insert into fire station
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','Hotline','191');");
            db.execSQL("insert into fire (city,name,phone) values('ကချင်','မြစ်ကြီးနား','074 252 2467');");
            db.execSQL("insert into fire (city,name,phone) values('မွန်','ကျိုက်ထို','057 60 045');");
            db.execSQL("insert into fire (city,name,phone) values('မွန်','ကော့ကရိတ်','058 40 191');");
            db.execSQL("insert into fire (city,name,phone) values('ရခိုင်','စစ်တွေ','043 21 605');");
            db.execSQL("insert into fire (city,name,phone) values('မကွေး','မကွေး - မီးသတ်စခန်း၁','063 28 491');");
            db.execSQL("insert into fire (city,name,phone) values('ပဲခူး','ပဲခူး - အမှတ်(၁)မီးသတ်စခန်း','052 222 1502');");

            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - အလုံ','01-220802');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဘုရင့်နောင်','01-681648');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဒဂုံဆိပ်ကမ်း','09-43204745');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - တောင်ဒဂုံ','01-590071');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ဒေါပုံ','01-553021');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - လှိုင်သာယာ','01-645017');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - လှိုင်','01-519578');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ထောက်ကြံ့','01-600178');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - အင်းစိန်','01-640070');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ကျောက်တံတား','01-252011');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ကြည့်မြင်တိုင်','01-534825');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - လေးထောင့်ကန်','01-599467');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - မရမ်းကုန်း','01-661501');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - မြောက်ဒဂုံ','01-584060');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - မြောက်ဥက္ကလာပ','09-425356252');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - တောင်ဥက္ကလာပ','01-562655');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - စမ်းချောင်း','01-527099');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ရွှေပေါက်ကံ','01-695506');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - ရွှေပြည်သာ','01-611014');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - တာမွေ','01-554893');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - သာကေတ','01-556834');");
            db.execSQL("insert into fire (city,name,phone) values('ရန်ကုန်','ရန်ကုန် - သင်္ဃန်းကျွန်း','01-562677');");

            db.setTransactionSuccessful();

          //  Toast.makeText(this, "Inserting is Successful!", Toast.LENGTH_SHORT).show();

        }catch (SQLiteException e1){
         //   Toast.makeText(this,e1.getMessage(), Toast.LENGTH_LONG).show();
        }finally {
            db.endTransaction();
        }
    }

    private void deleteTable() {
        db.beginTransaction();
        db.execSQL("delete from saveList");
        db.execSQL("delete from hospital");
        db.execSQL("delete from police");
        db.execSQL("delete from fire");
        //db.execSQL("DROP TABLE IF EXISTS contactList");
        Log.i("Delete ","S ");
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_map) {
            Intent newAct = new Intent(getApplicationContext(), FirebaseMapsViewActivity.class);
            startActivity(newAct);
        } else if (id == R.id.nav_news) {
            Intent newAct = new Intent(getApplicationContext(), ShowNewsActivity.class);
            startActivity(newAct);
        } else if (id == R.id.nav_knowledge) {

            Intent newAct = new Intent(getApplicationContext(), KnowledgeActivity.class);
            startActivity(newAct);

        } else if (id == R.id.nav_emergency) {
            Intent newAct = new Intent(getApplicationContext(), EmergencyActivity.class);
            startActivity(newAct);

        } else if (id == R.id.nav_charity) {
            Intent newAct = new Intent(getApplicationContext(), DonationActivity.class);
            startActivity(newAct);
        } else if (id == R.id.nav_earthquake) {
            Intent newAct = new Intent(getApplicationContext(), MercalliSensorActivity.class);
            startActivity(newAct);

        } else if (id == R.id.nav_weather) {
            Intent newAct = new Intent(getApplicationContext(), WeatherActivity.class);
            startActivity(newAct);

        } else if (id == R.id.nav_send) {
            Intent newAct = new Intent(getApplicationContext(), FeedBackActivity.class);
            startActivity(newAct);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public class MyAdapter extends ArrayAdapter {

        ArrayList array = new ArrayList<>();

        public MyAdapter(Context context, int textViewResourceId, ArrayList objects)
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
            view =inflater.inflate(R.layout.gridview,null);
            TextView textView = (TextView) view.findViewById(R.id.textView);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            textView.setText(((Item)array.get(position)).getitemName());
            imageView.setImageResource(((Item)array.get(position)).getitemImage());
            return view;

        }
    }
}
