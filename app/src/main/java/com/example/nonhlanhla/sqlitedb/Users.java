package com.example.nonhlanhla.sqlitedb;

/**
 * USER CLASS
 */

public class Users {

    int id;
    String editTextName;
    String editTextEmail;
    String editTextUsername;
    String editTextPassword1;
    String role;
    String surname;
    int marks;
    String comments;
    String examiner;

    public String getEditTextName() {
        return editTextName;
    }

    public void setEditTextName(String editTextName) {
        this.editTextName = editTextName;
    }

    public String getEditTextEmail() {
        return editTextEmail;
    }

    public void setEditTextEmail(String editTextEmail) {
        this.editTextEmail = editTextEmail;
    }

    public String getEditTextUsername() {
        return editTextUsername;
    }

    public void setEditTextUsername(String editTextUsername) {
        this.editTextUsername = editTextUsername;
    }

    public String getEditTextPassword1() {
        return editTextPassword1;
    }

    public void setEditTextPassword1(String editTextPassword1) {
        this.editTextPassword1 = editTextPassword1;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getGeography() {
        return geography;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getAfrikaans() {
        return afrikaans;
    }

    public void setAfrikaans(int afrikaans) {
        this.afrikaans = afrikaans;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    int physical;
    int life;
    int geography;
    int english;
    int afrikaans;
    int orientation;

    public Users(){

    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(int id) {
        this.id = id;
    }

    // getter
    public int getId() {
        return this.id;
    }

    public void setName(String editTextName) {
        this.editTextName = editTextName;
    }

    public String getName() {
        return this.editTextName;
    }

    public void setEmail(String editTextEmail) {
        this.editTextEmail = editTextEmail;
    }

    public String getEmail() {
        return this.editTextEmail;
    }

    public void setUsername(String editTextUsername) {
        this.editTextUsername = editTextUsername;
    }

    public String getUsername() {
        return this.editTextUsername;
    }

    public void setPassword1(String editTextPassword1) {
        this.editTextPassword1 = editTextPassword1;
    }

    public String getPassword1() {
        return this.editTextPassword1;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }
    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public String getExaminer() {
        return this.examiner;
    }


    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return this.marks;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return this.comments;
    }
    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getPhysical() {
        return this.physical;
}
}
