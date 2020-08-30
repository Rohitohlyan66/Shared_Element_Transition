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

public class MainActivity extends AppCompatActivity {

    Button btnMain;
    CircleImageView imageMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencing Views------>
        btnMain = findViewById(R.id.follow_btn_main);
        imageMain = findViewById(R.id.profile_image_main);


        //Removing Status Bar------>
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //Click Listener on Follow Button that opens second activity------->
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //New Intent------>
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

                //For transition of more than one Elements------>
                Pair<View, String> p1 = Pair.create((View) btnMain, "shared2");
                Pair<View, String> p2 = Pair.create((View) imageMain, "shared");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, p1, p2);
                startActivity(intent, activityOptions.toBundle());
            }
        });
    }
}