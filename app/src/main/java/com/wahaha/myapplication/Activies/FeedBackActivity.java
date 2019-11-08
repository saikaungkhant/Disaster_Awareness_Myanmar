package com.wahaha.myapplication.Activies;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.wahaha.myapplication.R;

public class FeedBackActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_feedback);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setTitle("အကြံပြုစာပေးပို့ရန်");
        navigationView.setNavigationItemSelectedListener(this);


        final EditText to = (EditText) findViewById(R.id.sendTo);
        final EditText subject = (EditText)findViewById(R.id.subjcet);
        final EditText message = (EditText)findViewById(R.id.EmailText);

        Button sendE = (Button)findViewById(R.id.sendEmail);
        sendE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toS = to.getText().toString();
                String subS = subject.getText().toString();
                String mesS = message.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
               // email.putExtra(Intent.EXTRA_EMAIL,toS);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{toS});
                email.putExtra(Intent.EXTRA_SUBJECT,subS);
                email.putExtra(Intent.EXTRA_TEXT,mesS);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose app to send mail"));
            }
        });

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

        } else if (id == R.id.nav_send) {
            Intent newAct = new Intent(getApplicationContext(), FeedBackActivity.class);
            startActivity(newAct);

        } 
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
