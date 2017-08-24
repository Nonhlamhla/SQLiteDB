package com.example.nonhlanhla.sqlitedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    DatabaseHelper1 helper;
    TextView textViewId, textViewName, textViewSurname, textViewMathematics, textViewPhysical, textViewLife,textViewGeography,
            textViewEnglish, textViewAfrikaans, textViewOrientation, textViewComment,textViewExaminer0, textViewAverage0;

    private Users user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

//        //DIALOG BOX INITIALIZATION
//        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ResultsActivity.this);
//        View mView = getLayoutInflater().inflate(R.layout.activity_results, null);
        helper = new DatabaseHelper1(getApplicationContext());
//
//
//
        textViewId = (TextView) findViewById(R.id.textViewId);
         textViewName = (TextView) findViewById(R.id.textViewName);
           textViewSurname = (TextView) findViewById(R.id.textViewSurname);
           textViewMathematics = (TextView) findViewById(R.id.textViewMathematics);
           textViewPhysical = (TextView) findViewById(R.id.textViewPhysical);
           textViewGeography = (TextView) findViewById(R.id.textViewGeography);
           textViewEnglish = (TextView) findViewById(R.id.textViewEnglish);
           textViewAfrikaans = (TextView) findViewById(R.id.textViewAfrikaans);
           textViewOrientation = (TextView) findViewById(R.id.textViewOrientation);
           textViewComment = (TextView) findViewById(R.id.textViewComment);
           textViewExaminer0 = (TextView) findViewById(R.id.textViewExaminer0);
        textViewLife = (TextView) findViewById(R.id.textViewLife);
        textViewAverage0 = (TextView) findViewById(R.id.textViewAverage0);
//
//

        ResultsClass user = helper.showData();




        textViewId.setText(""+user.getId());
        textViewName.setText(user.getName());
        textViewSurname.setText(user.getSurname());
        textViewMathematics.setText(""+user.getMarks());
        textViewPhysical.setText(""+user.getPhysical());
        textViewGeography.setText(""+user.getGeography());
        textViewEnglish.setText(""+user.getEnglish());
        textViewAfrikaans.setText(""+user.getAfrikaans());
        textViewOrientation.setText(""+user.getOrientation() );
        textViewComment.setText(""+user.getComments());
        textViewExaminer0.setText(""+user.getExaminer());
        textViewLife.setText(""+user.getLife());
        textViewAverage0.setText(""+user.getAverage());
//
//
//
//
//
//        mBuilder.setView(mView);
//        AlertDialog dialog = mBuilder.create();
//        dialog.show();
//        //DIALOG END

    }
}
