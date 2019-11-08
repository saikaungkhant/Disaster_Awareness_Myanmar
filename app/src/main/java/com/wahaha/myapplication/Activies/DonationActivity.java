package com.wahaha.myapplication.Activies;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.wahaha.myapplication.DonationAdapter;
import com.wahaha.myapplication.Donation;
import com.wahaha.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DonationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button btnInsert;

    Bundle myBundle;

    SQLiteDatabase db;

    String query = "";

    AlertDialog delete = null;

    ArrayList<String> sdata = new ArrayList<>();
    DonationAdapter adapter;
    List<Donation> donationList=new ArrayList<>();

    //button insert
    EditText editName, editRoll, editTotal, editResult;
    Button btnSave,btnView;

    //button view

    RecyclerView recyclerView;
    TextView txtphone;
    Donation donation;
    Boolean flag=false;
    String title,address,phone;
    int images;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        createTable();
        insertTable();
        viewData();
     //deleteTable();

    }

    private void deleteTable() {
        db.beginTransaction();
        db.execSQL("delete from donationInfo");
        db.execSQL("DROP TABLE IF EXISTS donationInfo");
        Log.i("Delete ","S ");
        db.setTransactionSuccessful();
        db.endTransaction();

    }

    private void viewData() {

        setContentView(R.layout.activity_nav_donation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setTitle("လူမှုရေးအသင်းများ");
        navigationView.setNavigationItemSelectedListener(this);

        db.beginTransaction();
        donationList=new ArrayList<>();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(DonationActivity.this));
        // recyclerView.setAdapter(adapter);
        query = "select * from donationInfo";

        Cursor c1;
        c1 = db.rawQuery(query, null);
        int index1 = c1.getColumnIndex("title");
        Log.i("Stuent","Result"+index1);
        // int index2 = c1.getColumnIndex("image");
        // Log.i("Image ","Result "+c1.getInt(2));
        int index3 = c1.getColumnIndex("address");
        int index4 = c1.getColumnIndex("phone");

        while (c1.moveToNext()) {
            title = c1.getString(index1);
            Log.i("Name", "Result" + title);
            // images = c1.getInt(index2);
            address = c1.getString(index3);
            phone = c1.getString(index4);

            if(title.equals("ကျော်သူ ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.kyawthu2, address, phone);
            }
            else if(title.equals("ဝေဠုကျော် ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.wailukyaw1, address, phone);
            }
            else if(title.equals("ဗမာ့ယဉ်ကျေးမှု ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.culture1, address, phone);
            }
            else if(title.equals("ဧရာဝတီ ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.ayeyarwaddy, address, phone);
            }
            else if(title.equals("ကိုရဲ ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.koye, address, phone);
            }
            else if(title.equals("ထူး ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.htoo, address, phone);
            }
            else if(title.equals("ကမ္ဘောဇ ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.kbz, address, phone);
            }
            else if(title.equals("ယူနီဆက် ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.unicef, address, phone);
            }
            else if(title.equals("နှင်းဆီရင်ခွင် ဖောင်ဒေးရှင်း"))
            {
                donation = new Donation(title,R.drawable.hninsiyinkhwin, address, phone);
            }




            // donation = new Donation(title,imageArray, address, phone);
            donationList.add(donation);
            System.out.print("Result" + donationList.get(0).getTitle());
        }
        adapter = new DonationAdapter(DonationActivity.this, donationList);
        recyclerView.setAdapter(adapter);


    }

    private void insertTable() {
        db.beginTransaction();

        try {

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ကျော်သူ ဖောင်ဒေးရှင်း','အမှတ်-၁၃/က၊ ဗိုလ်မှူးဘထူးလမ်း မြောက်ဒဂုံမြို့နယ်၊ရန်ကုန်','09421119566');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ဝေဠုကျော် ဖောင်ဒေးရှင်း','အမှတ်-၂၄၇၊ ကံ့ကော်မြိုင်လမ်း ၂၄ရပ်ကွက်၊ သုဝဏ္ဏမြို့နယ်၊ရန်ကုန်','09455500014');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ဗမာ့ယဉ်ကျေးမှု ဖောင်ဒေးရှင်း','အမှတ်-၂၇/၃က၊ ဗိုလ်တထောင်','09787204644');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ဧရာဝတီ ဖောင်ဒေးရှင်း','ဆူးလေ','01255838');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ကိုရဲ ဖောင်ဒေးရှင်း','မြောက်ဒဂုံမြို့နယ်၊ရန်ကုန်','09778733221');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ထူး ဖောင်ဒေးရှင်း','မြေညီထပ်၊ ကွန်ဒို အေ၊ မင်းဓမ္မ အိမ်ရာ မင်းဓမ္မလမ်း၊ရန်ကုန်','');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ကမ္ဘောဇ ဖောင်ဒေးရှင်း','ကမ္ဘောဇ ရုံးချုပ်၊ ရန်ကုန်','09951018555');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('ယူနီဆက် ဖောင်ဒေးရှင်','၂၃(က)၊ အင်းလျားမြိုင်လမ်း ရန်ကုန်','095065883');");

            db.execSQL("insert into donationInfo (title,address,phone)"
                    + " values('နှင်းဆီရင်ခွင် ဖောင်ဒေးရှင်း','တက္ကသိုလ်ရိပ်သာလမ်းသစ်၊ရန်ကုန်','0973076542');");


            db.setTransactionSuccessful();

           // Toast.makeText(DonationActivity.this, "Inserting Student Info is Successful!", Toast.LENGTH_LONG).show();

        } catch (SQLiteException e1) {
            //Toast.makeText(getBaseContext(), e1.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            db.endTransaction();
        }
        Log.i("Insert Table"," is ");

    }

    private void createTable() {
        try {
            db = SQLiteDatabase.openDatabase("data/data/com.wahaha.myapplication/myDonation",
                    null, SQLiteDatabase.CREATE_IF_NECESSARY);

            db.beginTransaction();

            db.execSQL("create table donationInfo ("
                    + "dID integer PRIMARY KEY AUTOINCREMENT, "
                    + "title text, "
                    + "address text, "
                    + "phone text);");

            db.setTransactionSuccessful();

          //  Toast.makeText(this, "Table was created", Toast.LENGTH_LONG).show();

        } catch (SQLiteException e) {
           // Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }finally {
            db.endTransaction();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
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
}
