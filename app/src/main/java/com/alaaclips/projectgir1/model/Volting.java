package com.alaaclips.projectgir1.model;

public class Volting {

    public static final String TABLE_NAME = "volting";
    public static final String VOLTING_ID = "id";
    public static final String EMAILEVOLTING = "Emailevolting";
    public static final String NAME_LAPEL = "namelapel";

    int id;
    String emailevolting;
    String namelapel;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + VOLTING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + EMAILEVOLTING + " TEXT,"
                    + NAME_LAPEL + " TEXT"
                    + ")";

    public Volting(int id, String emailevolting, String namelapel) {
        this.id = id;
        this.emailevolting = emailevolting;
        this.namelapel = namelapel;
    }

    public Volting() {
    }

    public Volting(String emailevolting, String namelapel) {
        this.emailevolting = emailevolting;
        this.namelapel = namelapel;
    }

    public int getId() {
        return id;
    }

    public String getEmailevolting() {
        return emailevolting;
    }

    public String getNamelapel() {
        return namelapel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmailevolting(String emailevolting) {
        this.emailevolting = emailevolting;
    }

    public void setNamelapel(String namelapel) {
        this.namelapel = namelapel;
    }
}
