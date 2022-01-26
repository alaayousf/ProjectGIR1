package com.alaaclips.projectgir1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alaaclips.projectgir1.model.Users;
import com.alaaclips.projectgir1.model.Volting;
import com.alaaclips.projectgir1.model.VotingList;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelpers extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 11;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public DatabaseHelpers(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create notes table
        sqLiteDatabase.execSQL(VotingList.CREATE_TABLE);
        sqLiteDatabase.execSQL(Users.CREATE_TABLE);
        sqLiteDatabase.execSQL(Volting.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + VotingList.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Users.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Volting.TABLE_NAME);

        // Create tables again
        onCreate(sqLiteDatabase);

    }

    public boolean insertNote(
            VotingList votingList
    ) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(VotingList.NAME_list, votingList.getName());
        values.put(VotingList.LOGO_LIST, votingList.getLogo());
        values.put(VotingList.DESCREBTION_LIST, votingList.getDescribe());
        values.put(VotingList.LEADER_LIST, votingList.getLeader());

        // insert row
        boolean id = db.insert(VotingList.TABLE_NAME, null, values) > 0;

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }


    public ArrayList<VotingList> getAllNotes() {
        ArrayList<VotingList> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + VotingList.TABLE_NAME + " ORDER BY " +
                VotingList.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                VotingList lotingList = new VotingList();
                lotingList.setId(cursor.getInt(cursor.getColumnIndex(VotingList.COLUMN_ID)));
                lotingList.setName(cursor.getString(cursor.getColumnIndex(VotingList.NAME_list)));
                lotingList.setLogo(cursor.getString(cursor.getColumnIndex(VotingList.LOGO_LIST)));
                lotingList.setDescribe(cursor.getString(cursor.getColumnIndex(VotingList.DESCREBTION_LIST)));
                lotingList.setLeader(cursor.getString(cursor.getColumnIndex(VotingList.LEADER_LIST)));

                notes.add(lotingList);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;

    }


    ////////////////////////////////////////////////////

    public boolean addNewUser(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Users.USER_NAME, users.getUserName());
        values.put(Users.EMAIL, users.getEmail());
        values.put(Users.PASSWORD, users.getPassword());
        values.put(Users.IMAGE, users.getImage());

        // insert row
        boolean id = db.insert(Users.TABLE_NAME, null, values) > 0;

        // close db connection
        db.close();


        return true;

    }

    public Users getuser(String seremaile) {

        //Users u =new Users();

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Users> usersArrayList = new ArrayList<>();


        Cursor c = db.rawQuery("select * from " + Users.TABLE_NAME + " where " +
                Users.EMAIL + "=" + seremaile, null);


        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Users u = new Users();
                u.setId(c.getString(c.getColumnIndex(Users.USER_ID)));
                u.setEmail(c.getString(c.getColumnIndex(Users.EMAIL)));
                u.setImage(c.getBlob(c.getColumnIndex(Users.IMAGE)));
                u.setPassword(c.getString(c.getColumnIndex(Users.PASSWORD)));
                u.setUserName(c.getString(c.getColumnIndex(Users.USER_NAME)));

                usersArrayList.add(u);
            } while (c.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return usersArrayList.get(0);
    }





    public  ArrayList<Users> getallUser(){


        ArrayList<Users> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Users.TABLE_NAME + " ORDER BY " +
                Users.USER_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Users u = new Users();
                u.setEmail(c.getString(c.getColumnIndex(Users.EMAIL)));
                u.setImage(c.getBlob(c.getColumnIndex(Users.IMAGE)));
                u.setPassword(c.getString(c.getColumnIndex(Users.PASSWORD)));
                u.setUserName(c.getString(c.getColumnIndex(Users.USER_NAME)));
                notes.add(u);
            } while (c.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;

    }


    /////////////


    public boolean addVolting(Volting vo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Volting.NAME_LAPEL, vo.getNamelapel());
        values.put(Volting.EMAILEVOLTING, vo.getEmailevolting());

        // insert row
        boolean id = db.insert(Volting.TABLE_NAME, null, values) > 0;

        // close db connection
        db.close();

        return true;

    }





    public  ArrayList<Volting> getALLVoltingUser() {


        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Volting> usersArrayList = new ArrayList<>();


        Cursor c = db.rawQuery("select * from " + Volting.TABLE_NAME, null);


        // Cursor c = db.rawQuery("SELECT * FROM "+Volting.TABLE_NAME +"WHERE"+ Volting.EMAILEVOLTING+ "= '"+seremaile.trim()+"'", null);


        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Volting u = new Volting();
                u.setId(c.getInt(c.getColumnIndex(Volting.VOLTING_ID)));
                u.setEmailevolting(c.getString(c.getColumnIndex(Volting.EMAILEVOLTING)));
                u.setNamelapel(c.getString(c.getColumnIndex(Volting.NAME_LAPEL)));

                usersArrayList.add(u);
            } while (c.moveToNext());
        }

        // close db connection
        db.close();



        // return notes list
        return usersArrayList;

    }







    public Volting getVoltingUser(String seremaile) {


        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Volting> usersArrayList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + Volting.TABLE_NAME + " ORDER BY " +
                Volting.VOLTING_ID + " DESC";


      //  Cursor c = db.rawQuery("select * from " + Volting.TABLE_NAME, null);
         Cursor c = db.rawQuery(selectQuery , null);


        // Cursor c = db.rawQuery("SELECT * FROM "+Volting.TABLE_NAME +"WHERE"+ Volting.EMAILEVOLTING+ "= '"+seremaile.trim()+"'", null);


        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Volting u = new Volting();
                u.setId(c.getInt(c.getColumnIndex(Volting.VOLTING_ID)));
                u.setEmailevolting(c.getString(c.getColumnIndex(Volting.EMAILEVOLTING)));
                u.setNamelapel(c.getString(c.getColumnIndex(Volting.NAME_LAPEL)));

                usersArrayList.add(u);
            } while (c.moveToNext());
        }

        // close db connection
        db.close();



        // return notes list
        return findUsingEnhancedForLoop(seremaile,usersArrayList);

    }



    public Volting findUsingEnhancedForLoop(String name, ArrayList<Volting> customers) {

        for (Volting customer : customers) {
            if (customer.getEmailevolting().equals(name)) {
                return customer;
            }
        }
        return null;
    }



}
