package com.example.nonhlanhla.sqlitedb;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TeachersTableActivity extends AppCompatActivity {

    DatabaseHelper1 helper;

    Button btnAdd, btnView, btnUpdate, btnDelete;
    EditText editTextName, editTextSurname, editTextMarks, editTextComments, editTextId
            ,editTextPhysical,editTextLife, editTextGeography, editTextEnglish,editTextAfrikaans, editTextOrientation,editTextExaminer;
    TextView textViewTitle,textViewSubjects,TextViewTotal ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_table);

        helper = new DatabaseHelper1(getApplicationContext());

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        editTextMarks = (EditText) findViewById(R.id.editTextMarks);
        editTextComments = (EditText) findViewById(R.id.editTextComments);
       editTextId = (EditText) findViewById(R.id.editTextId);


        editTextPhysical = (EditText) findViewById(R.id.editTextPhysical);
        editTextLife = (EditText) findViewById(R.id.editTextLife);
        editTextGeography = (EditText) findViewById(R.id.editTextGeography);
        editTextEnglish = (EditText) findViewById(R.id.editTextEnglish);
        editTextAfrikaans = (EditText) findViewById(R.id.editTextAfrikaans);
        editTextOrientation = (EditText) findViewById(R.id.editTextOrientation);
        editTextExaminer = (EditText) findViewById(R.id.editTextExaminer);


        textViewTitle = (TextView)findViewById(R.id.textViewTitle);
        textViewSubjects = (TextView)findViewById(R.id.textViewSubjects);
        TextViewTotal = (TextView)findViewById(R.id.TextViewTotal);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);


        helper = new DatabaseHelper1(this);//this would go in onCreate()


        /**
         * CALLS/INVOKES METHODS
         */
        AddData();
        ViewData();
        UpdateData();
        DeleteData();
    }

    public void AddData() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                String marks = editTextMarks.getText().toString();
                String comments = editTextComments.getText().toString();

                String physical = editTextPhysical.getText().toString();
                String life = editTextLife.getText().toString();
                String geography = editTextGeography.getText().toString();
                String english = editTextEnglish.getText().toString();
                String afrikaans = editTextAfrikaans.getText().toString();
                String orientation = editTextOrientation.getText().toString();
                String examiner = editTextExaminer.getText().toString();
                String total  = TextViewTotal.getText().toString();


                double physic = Double.parseDouble(physical);
                double lifeO = Double.parseDouble(life);
                double geo = Double.parseDouble(geography);
                double eng = Double.parseDouble(english);
                double afri = Double.parseDouble(afrikaans);
                double orie = Double.parseDouble(orientation);
                double ma = Double.parseDouble(marks);

                //CALCULATES AVERAGE
                double totalmark = physic + lifeO + geo + eng + afri + orie + ma;
                double totalmarks = totalmark / 700;
                double perc = totalmarks * 100;
                totalmark = Integer.valueOf((int) perc);



                    boolean insertData = helper.addData(name, surname, marks, comments, physical, life, geography, english, afrikaans, orientation, examiner, total);

                    if (insertData == true) {
                        Toast.makeText(TeachersTableActivity.this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(TeachersTableActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
                    }
                if (totalmark > 50) {
                    Toast.makeText(TeachersTableActivity.this, "Passed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TeachersTableActivity.this, "Failed" + name, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    public void ViewData() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ResultsClass data = helper.showData();

//                if (data.getCount() == 0) {
//                    display("Error", "No Data Found.");
//                    return;
//                }

                /**
                 * LISTS ALL THE DATA IN ORDER
                 */
                StringBuffer buffer = new StringBuffer();
//                while (data.moveToNext()) {
                    buffer.append("ID: " + data.getId() + "\n");
                    buffer.append("Name: " + data.getName() + "\n");
                    buffer.append("Surname: " + data.getSurname() + "\n");
                    buffer.append("Mathematics: " + data.getMarks() + "\n");
                    buffer.append("Physical Sciences: " + data.getPhysical() + "\n");
                    buffer.append("Life Sciences: " + data.getLife() + "\n");
                    buffer.append("Geography: " + data.getGeography() + "\n");
                    buffer.append("English: " + data.getEnglish() + "\n");
                    buffer.append("Afrikaans: " + data.getAfrikaans() + "\n");
                    buffer.append("Life Orientation: " + data.getOrientation() + "\n");
                    buffer.append("Comments: " + data.getComments() + "\n");
                    buffer.append("Examiner: " + data.getExaminer() + "\n");
                   buffer.append("Average: " + data.getAverage() + "\n");

                    display("Data entry: Teachers Portal:", buffer.toString());
                }
//            }
        });
   }


    public void display(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void UpdateData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = editTextId.getText().toString().length();
                if (temp > 0) {
                    boolean update = helper.updateData(editTextId.getText().toString(), editTextName.getText().toString(),
                            editTextSurname.getText().toString(), editTextMarks.getText().toString(), editTextComments.getText().toString(),
                            editTextPhysical.getText().toString(), editTextLife.getText().toString(), editTextGeography.getText().toString(), editTextEnglish.getText().toString(), editTextAfrikaans.getText().toString(),
                            editTextOrientation.getText().toString(), editTextExaminer.getText().toString());
                    if (update == true) {
                        Toast.makeText(TeachersTableActivity.this, "Successfully Updated Data!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(TeachersTableActivity.this, "Something Went Wrong :(.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(TeachersTableActivity.this, "You Must Enter An ID to Update :(.", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = editTextId.getText().toString().length();
                if (temp > 0) {
                    Integer deleteRow = helper.deleteData(editTextId.getText().toString());
                    if (deleteRow > 0) {
                        Toast.makeText(TeachersTableActivity.this, "Successfully Deleted The Data!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(TeachersTableActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(TeachersTableActivity.this, "You Must Enter An ID to Delete :(.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    }

