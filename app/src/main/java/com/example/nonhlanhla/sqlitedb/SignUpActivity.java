package com.example.nonhlanhla.sqlitedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements
        View.OnClickListener, AdapterView.OnItemSelectedListener {

    DatabaseHelper1 helper;

    TextView textViewName, textViewEmail, textViewUsername, textViewPassword1, textViewConfirmPass;
    EditText editTextName, editTextEmail, editTextUsername, editTextPassword1, editTextConfirmPass;
    Button btnSignUp;

    // CUSTOM SELECTION SPINNER STUDENT/TEACHER
    Spinner spinner;
    String Select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        helper = new DatabaseHelper1(getApplicationContext());

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewPassword1 = (TextView) findViewById(R.id.textViewPassword1);
        textViewConfirmPass = (TextView) findViewById(R.id.textViewConfirmPass);
        spinner = (Spinner) findViewById(R.id.spinner);

        helper = new DatabaseHelper1(this);//this would go in onCreate()

        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (i == 2) {
            Select = "Teacher";
            Toast.makeText(SignUpActivity.this, ""+i, Toast.LENGTH_LONG).show();
        }

        if (i == 1) {
            Select = "Student";
            Toast.makeText(SignUpActivity.this, ""+Select, Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void OnSignUp(View v) {

        if (v.getId() == R.id.btnSignUp) {


            EditText editTextName = (EditText) findViewById(R.id.editTextName);
            EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);
            EditText editTextPassword1 = (EditText) findViewById(R.id.editTextPassword1);
            EditText editTextConfirmPass = (EditText) findViewById(R.id.editTextConfirmPass);

            String editTextNamestring = editTextName.getText().toString();
            String editTextEmailstring = editTextEmail.getText().toString();
            String editTextUsernamestring = editTextUsername.getText().toString();
            String editTextPassword1string = editTextPassword1.getText().toString();
            String editTextConfirmPassstring = editTextConfirmPass.getText().toString();

            /**
             * AUTHENTICATES THAT BOTH PASSWORDS ARE THE SAME
             */
            if (!editTextPassword1string.equals(editTextConfirmPassstring)) {

                Toast.makeText(SignUpActivity.this, "Passwords don't match!", Toast.LENGTH_LONG).show();
            } else {

//                Intent intent = new Intent(SignUpActivity.this, TeachersTableActivity.class);
//                startActivity(intent);

                Toast.makeText(SignUpActivity.this, "Loading Data", Toast.LENGTH_LONG).show();


                /**
                 * INSERT USER DETAILS IN DATABASE
                 */
                Users u = new Users();
                u.setName(editTextNamestring);
                u.setEmail(editTextEmailstring);
                u.setUsername(editTextUsernamestring);
                u.setPassword1(editTextPassword1string);
                u.setRole(Select);


                helper.insertUsers(u);
                if (Select == "Teacher") {
                    Intent i = new Intent(SignUpActivity.this, TeachersTableActivity.class);
                    startActivity(i);
                }

                if (Select == "Student") {
                    Intent i = new Intent(SignUpActivity.this, ResultsActivity.class);
                    startActivity(i);
                }


            }
        }
    }

    @Override
    public void onClick(View view) {

    }
}








