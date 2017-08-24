package com.example.nonhlanhla.sqlitedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    DatabaseHelper1 helper = new DatabaseHelper1(this);

    TextView textViewUsername, textViewPassword1;
    EditText editTextUsername, editTextPassword;
    Button btnLogin, btnSignUp1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewPassword1 = (TextView) findViewById(R.id.textViewPassword1);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp1 = (Button) findViewById(R.id.btnSignUp1);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == R.id.btnLogin) {
                    editTextUsername = (EditText) findViewById(R.id.editTextUsername);
                    String string = editTextUsername.getText().toString();

                    editTextPassword = (EditText) findViewById(R.id.editTextPassword);
                    String pass = editTextPassword.getText().toString();

                    String[] p = helper.searchPass(string);
                    String password = p[0];
                    String role =p[2];
                    if (password.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();

                    }else

                    if (pass.equals(password)) {
                        Toast.makeText(MainActivity.this, "Role "+role, Toast.LENGTH_SHORT).show();

                        if (role.equalsIgnoreCase("Teacher")){
                            Intent i = new Intent(MainActivity.this, TeachersTableActivity.class);
                            i.putExtra("Username", string);
                            startActivity(i);
                        }
                        else if (role.equalsIgnoreCase("Student")) {
                            Intent i = new Intent(MainActivity.this, ResultsActivity.class);
                            i.putExtra("Username", string);
                            startActivity(i);
                        }

                    } else {

                        Toast.makeText(MainActivity.this, "Username and Password don't match" +password+" "+role, Toast.LENGTH_SHORT).show();
                    }

                }

//                if (view.getId() == R.id.btnLogin) {
//
//                    editTextUsername = (EditText) findViewById(R.id.editTextUsername);
//                    String string = editTextUsername.getText().toString();
//
//                    editTextPassword = (EditText) findViewById(R.id.editTextPassword);
//                    String pass = editTextPassword.getText().toString();
//
//                    String password = helper.searchPass(string);
//                    if (pass.equals(password)) {
//                        Intent intent = new Intent(MainActivity.this, SecondScreenActivity.class);
//                        intent.putExtra("Username", string);
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(MainActivity.this, "Username and Password don't match", Toast.LENGTH_LONG).show();
//                    }
//                }
            }

        });

        btnSignUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}


