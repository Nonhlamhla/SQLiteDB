package com.example.nonhlanhla.sqlitedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SplashActivity extends AppCompatActivity {


    ImageButton imageButtonTeachersP, imageButtonStudentsP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        imageButtonTeachersP = (ImageButton)findViewById(R.id.imageButtonTeachersP);
        imageButtonStudentsP = (ImageButton)findViewById(R.id.imageButtonStudentsP);



        imageButtonTeachersP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        imageButtonStudentsP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
