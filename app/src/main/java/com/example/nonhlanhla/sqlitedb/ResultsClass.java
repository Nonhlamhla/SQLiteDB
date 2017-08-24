package com.example.nonhlanhla.sqlitedb;

/**
 * Created by Admin on 8/23/2017.
 */

public class ResultsClass {


    String comments;
    String examiner;
    int marks;
    int id;
    int physical;
    int life;
    int geography;
    int english;
    int afrikaans;
    int orientation;
    int average;

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    String name;


    public ResultsClass(){

    }


    public void setId(int id) {
        this.id = id;
    }

    // getter
    public int getId() {
        return this.id;
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

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return this.life;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }

    public int getGeography() {
        return this.geography;
    }
    public void setEnglish(int english) {
        this.english = english;
    }

    public int getEnglish() {
        return this.english;
    }
    public void setAfrikaans(int afrikaans) {
        this.afrikaans = afrikaans;
    }

    public int getAfrikaans() {
        return this.afrikaans;
    }
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getOrientation() {
        return this.orientation;
    }

}
