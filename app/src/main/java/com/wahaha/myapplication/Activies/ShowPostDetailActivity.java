package com.wahaha.myapplication.Activies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wahaha.myapplication.R;

import java.util.ArrayList;

public class ShowPostDetailActivity extends AppCompatActivity {

    private TextView textDetailTitle,textDetailDate,textDetailDescription;
    private Button btnDeletePost;
    private String receiveUserId;

    private DatabaseReference mDatabase;
    private ArrayList<String> arrayList = new ArrayList<>();
    NewsModel newsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showPostDetail();

    }

    protected void deletePost(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.delete_post_confirm_dialog, null);
        dialogBuilder.setView(dialogView);

        final Button buttonDeletePostOK = (Button)dialogView.findViewById(R.id.buttonDeletePostOK);

        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonDeletePostOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference deleteReference = FirebaseDatabase.getInstance().getReference("Disaster").child("news").child(receiveUserId);

                deleteReference.removeValue();
                Toast.makeText(getApplicationContext(), "Post is successfully deleted!!!", Toast.LENGTH_LONG).show();
                b.dismiss();
                onBackPressed();
            }
        });



    }


    protected void showPostDetail(){
        setContentView(R.layout.activity_show_post_detail);

//        textDetailTitle = (TextView)findViewById(R.id.textDetailTitle);
        textDetailDate = (TextView)findViewById(R.id.textDetailDate);
        textDetailDescription = (TextView)findViewById(R.id.textDetailDescription);


        //newsModel= (NewsModel) getIntent().getExtras().get("newsModel");
        String description= (String) getIntent().getExtras().get("description");
        String date=(String) getIntent().getExtras().get("date");
        String title=(String) getIntent().getExtras().get("title");
        getSupportActionBar().setTitle(title);
        textDetailDate.setText(date);
        textDetailDescription.setText(description);
//        textDetailTitle.setText(title);


        receiveUserId  = getIntent().getExtras().get("keyId").toString();
        System.out.println("ID: "+receiveUserId);

       /* mDatabase = FirebaseDatabase.getInstance().getReference().child("news").child(receiveUserId);

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                arrayList.add(value);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        System.out.println("Size,,,,,,,,,,"+ arrayList.size()+"\n");
//        textDetailTitle.setText(arrayList.get(4));
//        textDetailDate.setText(arrayList.get(0));
//        textDetailDescription.setText(arrayList.get(1));*/

    }
}
