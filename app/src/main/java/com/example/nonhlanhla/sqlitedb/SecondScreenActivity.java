package com.example.nonhlanhla.sqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondScreenActivity extends AppCompatActivity {

    TextView textViewWelcome, textViewDisplayUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        textViewWelcome = (TextView)findViewById(R.id.textViewWelcome);
        textViewDisplayUser = (TextView)findViewById(R.id.textViewDisplayUser);

        String username = getIntent().getStringExtra("Username");
        textViewDisplayUser.setText(username);

    }
}
