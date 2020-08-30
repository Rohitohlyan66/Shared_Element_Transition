package com.example.sharedelementtransition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    Button btnProfile;
    CircleImageView imageMain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //Referencing Views------>
        btnProfile = findViewById(R.id.follow_btn);
        imageMain2 = findViewById(R.id.profile_image);


        //Removing Status Bar------>
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //Click Listener on Follow Button that opens first activity------->
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //New Intent------>
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);



                //For transition of more than one Elements------>
                Pair<View, String> p1 = Pair.create((View) btnProfile, "shared2");
                Pair<View, String> p2 = Pair.create((View) imageMain2, "shared");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(ProfileActivity.this, p1, p2);
                startActivity(intent, activityOptions.toBundle());
            }
        });
    }
}