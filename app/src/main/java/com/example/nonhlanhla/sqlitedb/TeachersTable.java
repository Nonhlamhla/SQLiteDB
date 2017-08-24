package com.example.nonhlanhla.sqlitedb;

/**
 * Created by Admin on 8/17/2017.
 */

public class TeachersTable {

    int id;
    String editTextName;
    String editTextSurname;
    String editTextMarks;
    String editTextComments;


    public void setId(int id) {
        this.id = id;
    }
    // getter
    public int getId() {
        return this.id;
    }
    public void setName(String editTextName){
        this.editTextName = editTextName;
    }

    public String getName(){
        return this.editTextName;
    }

    public void setSurname (String editTextSurname){
        this.editTextSurname = editTextSurname;
    }

    public String getSurname(){
        return this.editTextSurname;
    }

    public void setMarks(String editTextMarks){
        this.editTextMarks = editTextMarks;
    }

    public String getMarks(){
        return this.editTextMarks;
    }

    public void setComments (String editTextComments){
        this.editTextComments = editTextComments;
    }

    public String getComments(){
        return this.editTextComments;
    }
}
