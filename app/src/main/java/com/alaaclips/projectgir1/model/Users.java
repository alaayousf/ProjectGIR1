package com.alaaclips.projectgir1.model;

public class Users {

    public static final String TABLE_NAME = "user";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String IMAGE = "image";

    String userName;
    String Password;
    String email;
    byte[] image;
    String id;


    public Users(String userName, String password, String email, byte[] image, String id) {
        this.userName = userName;
        Password = password;
        this.email = email;
        this.image = image;
        this.id = id;
    }

    public Users() {
    }

    public Users(String userName, String password, String email, byte[] image) {
        this.userName = userName;
        this.Password = password;
        this.email = email;
        this.image = image;
    }

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + USER_NAME + " TEXT,"
                    + PASSWORD + " TEXT,"
                    + EMAIL + " TEXT,"
                    + IMAGE + " BLOB"
                    + ")";


    public static final String SAERSH_USER = "SELECT * FROM "+ "user" + " WHERE "
            + "email" + " = " + "uuee";






    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getImage() {
        return image;
    }

    public String getId() {
        return id;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }
}
