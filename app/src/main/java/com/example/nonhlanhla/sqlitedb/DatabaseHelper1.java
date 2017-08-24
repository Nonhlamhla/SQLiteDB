package com.example.nonhlanhla.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/15/2017.
 */

public class DatabaseHelper1 extends SQLiteOpenHelper {

    //    // Logcat tag
    public static final String TAG = "DatabaseHelper1";

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "Statement.db";


    // Table Names
    public static final String TABLE_USERS = "Learners_Table";
    public static final String TABLE_STUDENTS = "Report_Table";

    // Common column names
    private static final String id = "ID";

    /**
     * TABLE USERS, TABLE NAMES
     */
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "EMAIL";
    public static final String COL4 = "USERNAME";
    public static final String COL5 = "PASSWORD";
    public static final String COL6 = "ROLE";

    /**
     * TABLE TEACHERS, TABLE NAMES
     */
    public static final String ROW1 = "ID";
    public static final String ROW2 = "NAME";
    public static final String ROW3 = "SURNAME";
    public static final String ROW4 = "MARKS";
    public static final String ROW5 = "COMMENTS";
    public static final String ROW6 = "PHYSICAL";
    public static final String ROW7 = "LIFE";
    public static final String ROW8 = "GEO";
    public static final String ROW9 = "ENGLISH";
    public static final String ROW10 = "AFRIKAANS";
    public static final String ROW11 = "ORIENTATION";
    public static final String ROW12 = "EXAMINER";


    SQLiteDatabase db;


    // Table Create Statements
    // USERS table create statement
    private static final String TABLE_CREATE_USERS = "create table Learners_Table (ID integer primary key not null , " +
            "NAME text not null , EMAIL text not null , USERNAME text not null , PASSWORD text not null, ROLE text not null);";

    // TEACHERS table create statement
    private static final String TABLE_CREATE_STUDENTS = " create table Report_Table (ID integer primary key autoincrement , " +
            "NAME text not null , SURNAME text not null , MARKS text not null , COMMENTS text not null, PHYSICAL text not null, LIFE text not null, GEO text not null, ENGLISH text not null, AFRIKAANS text not null, ORIENTATION text not null, EXAMINER text not null);";


    public DatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        // creating required tables
        db.execSQL(TABLE_CREATE_USERS);
        db.execSQL(TABLE_CREATE_STUDENTS);


    }

    public void insertUsers(Users u) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = " Select * from Learners_Table ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COL1, count);
        values.put(COL2, u.getName());
        values.put(COL3, u.getEmail());
        values.put(COL4, u.getUsername());
        values.put(COL5, u.getPassword1());
        values.put(COL6, u.getRole());


        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public String[] searchPass(String password) {
        db = this.getReadableDatabase();
        String query = "Select * from Learners_Table";
//    Cursor cursor = db.rawQuery(query, null); //WORKS
        Cursor cursor = db.rawQuery(query, null);


        String[] b = new String[3];
        b[0] = "not found";

        if (cursor.moveToFirst()) {
            do {
                b[1] = cursor.getString(cursor.getColumnIndex(COL4));


                if (b[1].equals(password)) {
                    b[0] = cursor.getString(cursor.getColumnIndex(COL5));

                    break;
                }
                b[2] = cursor.getString(cursor.getColumnIndex(COL6));
            }
            while (cursor.moveToNext());
        }
//        String editTextUsername, editTextPassword;
//        editTextPassword = "not found";
//        if (cursor.moveToFirst()) {
//            do {
//                editTextUsername = cursor.getString(0);
//
//                if (editTextUsername.equals(Username)) {
//                    editTextPassword = cursor.getString(1);
//                    break;
//                }
//            }
//            while (cursor.moveToFirst());
//        }
       return b;

    }

        @Override
        public void onUpgrade (SQLiteDatabase db,int i, int i1){

            Log.w(TAG,
                    "Upgrading the database from version " + i + " to " + i1);

            //clear all data
//        db.execSQL("DROP IF TABLE EXISTS " + TABLE_USERS);
            String query = "DROP TABLE IF EXITS " + TABLE_USERS;
            db.execSQL(query);
            db.execSQL("DROP IF TABLE EXISTS " + TABLE_STUDENTS);

            //recreate the tables
            onCreate(db);


        }


    /**
     * TEACHERS TABLE METHODS
     */

    public boolean addData(String name, String surname, String marks, String comments, String physical, String life, String geography, String english, String afrikaans, String orientation, String examiner, String total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROW2, name);
        contentValues.put(ROW3, surname);
        contentValues.put(ROW4, marks);
        contentValues.put(ROW5, comments);
        contentValues.put(ROW6, physical);
        contentValues.put(ROW7, life);
        contentValues.put(ROW8, geography);
        contentValues.put(ROW9, english);
        contentValues.put(ROW10, afrikaans);
        contentValues.put(ROW11, orientation);
        contentValues.put(ROW12, examiner);


        long result = db.insert(TABLE_STUDENTS, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * VIEWS THE DATA INSERTED
     */



    public ResultsClass showData() {
        List<ResultsClass> users = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_STUDENTS, null);
        ResultsClass users1=null;
        if (data.moveToFirst()) {
            do {
                users1 = new ResultsClass();
                users1.setId(data.getInt(data.getColumnIndex(ROW1)));
                users1.setName(data.getString(data.getColumnIndex(ROW2)));
                users1.setSurname(data.getString(data.getColumnIndex(ROW3)));
                users1.setMarks(data.getInt(data.getColumnIndex(ROW4)));
                users1.setComments(data.getString(data.getColumnIndex(ROW5)));
                users1.setPhysical(data.getInt(data.getColumnIndex(ROW6)));
                users1.setLife(data.getInt(data.getColumnIndex(ROW7)));
                users1.setGeography(data.getInt(data.getColumnIndex(ROW8)));
                users1.setEnglish(data.getInt(data.getColumnIndex(ROW9)));
                users1.setAfrikaans(data.getInt(data.getColumnIndex(ROW10)));
                users1.setOrientation(data.getInt(data.getColumnIndex(ROW11)));
                users1.setExaminer(data.getString(data.getColumnIndex(ROW12)));

            } while (data.moveToNext());
        }
        return users1;
    }




    /**
     *    UPDATES DATA
     */  public boolean updateData(String id, String name, String surname, String marks, String comments, String physical, String life, String geography, String english, String afrikaans, String orientation, String examiner){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROW1,id);
        contentValues.put(ROW2,name);
        contentValues.put(ROW3,surname);
        contentValues.put(ROW4,marks);
        contentValues.put(ROW5,comments);
        contentValues.put(ROW6, physical);
        contentValues.put(ROW7, life);
        contentValues.put(ROW8, geography);
        contentValues.put(ROW9, english);
        contentValues.put(ROW10, afrikaans);
        contentValues.put(ROW11, orientation);
        contentValues.put(ROW12, examiner);
        db.update(TABLE_STUDENTS, contentValues, "ID = ?", new String[] {id});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_STUDENTS, "ID = ?", new String[] {id});
    }



}
