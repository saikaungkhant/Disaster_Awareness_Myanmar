package com.wahaha.myapplication.Activies;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wahaha.myapplication.R;

public class FirebaseMapsViewActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener, GoogleMap.OnMarkerClickListener, NavigationView.OnNavigationItemSelectedListener{

    private GoogleMap mMap;
    private ChildEventListener mChildEventListener;
    private DatabaseReference mUsers;
    Marker marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_map);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("မြေပုံကြည့်ရန်");
// Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ChildEventListener mChildEventListener;
        mUsers = FirebaseDatabase.getInstance().getReference("Disaster");
        mUsers.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot s : dataSnapshot.child("Data").getChildren()) {
                    DisasterInformation disastermap = s.getValue(DisasterInformation.class);
                    //Toast.makeText(FirebaseMapsViewActivity.this, s.toString(), Toast.LENGTH_SHORT).show();

                    LatLng location = new LatLng(disastermap.latitude, disastermap.longitude);
                    Log.d("sdfsf", String.valueOf(disastermap.latitude));

                    if (disastermap.disaster.equals("ဆိုင်ကလုန်း")) {
                        mMap.addMarker(new MarkerOptions().position(location).snippet(disastermap.info).title("ဆိုင်ကလုန်း")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.cyclone_icon));
                    } else if (disastermap.disaster.equals("မြေငလျင်")) {
                        mMap.addMarker(new MarkerOptions().position(location).snippet(disastermap.info).title("မြေငလျင်")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.earthquake_icon_small));
                    } else if (disastermap.disaster.equals("ရေကြီးခြင်း")) {
                        mMap.addMarker(new MarkerOptions().position(location).snippet(disastermap.info).title("ရေကြီးခြင်း")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.flood_icon));
                    } else if (disastermap.disaster.equals("မြေပြိုခြင်း")) {
                        mMap.addMarker(new MarkerOptions().position(location).snippet(disastermap.info).title("မြေပြိုခြင်း")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.landslide));
                    } else if (disastermap.disaster.equals("မိုးခေါင်ရေရှား")) {
                        mMap.addMarker(new MarkerOptions().position(location).snippet(disastermap.info).title("မိုးခေါင်ရေရှား")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.drought_small));
                    } else if (disastermap.disaster.equals("ခရမ်းလွန်ရောင်ခြည်မြင့်မား")) {
                        mMap.addMarker(new MarkerOptions().position(location).snippet(disastermap.info).title("ခရမ်းလွန်ရောင်ခြည်မြင့်မား")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.uv_small));
                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onMapReady(GoogleMap   googleMap) {
        mMap = googleMap;
        googleMap.setOnMarkerClickListener(this);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraPosition googlePlex = CameraPosition.builder()
                .target(new LatLng(21.9162, 95.9560))
                .zoom((float) 5.5)
                .bearing(0)
                .tilt(45)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 1000, null);


    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
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