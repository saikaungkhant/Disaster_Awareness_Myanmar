package com.wahaha.myapplication.Activies;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.wahaha.myapplication.R;

public class EarthquakeEmergencyStepsActivity extends AppCompatActivity {

    Button issuealert,emergencycontacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_emergency_steps);

    }
}
