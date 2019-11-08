package com.wahaha.myapplication.Activies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wahaha.myapplication.R;

public class ShowNewsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private FirebaseRecyclerOptions<NewsModel> options;
    private FirebaseRecyclerAdapter<NewsModel, MyRecyclerViewHolder> adapter;

    private String dateString="";
    private String titletring = "";
    private String descriptionString= "";
    private String importantString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showAllPost2();

    }// onCreate

    @Override
    protected void onStart() {
        super.onStart();

        titletring= "";
        dateString = "";
        descriptionString = "";
        importantString = "";


        showAllPost2();
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

    public void showAllPost2(){
        setContentView(R.layout.activity_nav_news);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("ဘေးအန္တရာယ် သတင်းများ");
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);


        //reverse the order
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Disaster").child("news");

        options = new FirebaseRecyclerOptions.Builder<NewsModel>()
                .setQuery(databaseReference,NewsModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<NewsModel, MyRecyclerViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyRecyclerViewHolder myRecyclerViewHolder, final int position, @NonNull final NewsModel newsModel) {
                myRecyclerViewHolder.txtTitle.setText(newsModel.getTitle());
                myRecyclerViewHolder.txtDate.setText(newsModel.getDate());

                myRecyclerViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        String keyId = getRef(position).getKey();
                        String description=newsModel.getDescription();
                        String title=newsModel.getTitle();
                        String date=newsModel.getDate();

                        Intent intent = new Intent(ShowNewsActivity.this,ShowPostDetailActivity.class);
                        intent.putExtra("description", description);
                        intent.putExtra("title", title);
                        intent.putExtra("date", date);
                        intent.putExtra("keyId",keyId);

                        startActivity(intent);

                    }
                });
            }

            @NonNull
            @Override
            public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(getBaseContext()).inflate(R.layout.post_item,parent,false);
                return new MyRecyclerViewHolder(itemView);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStop() {
        if(adapter != null){
            adapter.stopListening();
        }
        super.onStop();
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
}
