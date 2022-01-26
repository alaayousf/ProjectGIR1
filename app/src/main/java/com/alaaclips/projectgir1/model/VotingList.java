package com.alaaclips.projectgir1.model;


public class VotingList {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String NAME_list = "name";
    public static final String LOGO_LIST = "logo";
    public static final String DESCREBTION_LIST = "describe";
    public static final String LEADER_LIST = "leader";


    int id;
    String name;
    String logo;
    String describe;
    String leader;



    public VotingList() {
    }


    public VotingList(int id, String name, String logo, String describe, String leader) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.describe = describe;
        this.leader = leader;
    }

    public VotingList(String name, String logo, String describe, String leader) {
        this.name = name;
        this.logo = logo;
        this.describe = describe;
        this.leader = leader;
    }

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + NAME_list + " TEXT,"
                    + LOGO_LIST + " TEXT,"
                    + DESCREBTION_LIST + " TEXT,"
                    + LEADER_LIST + " TEXT"
                    + ")";



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public String getDescribe() {
        return describe;
    }

    public String getLeader() {
        return leader;
    }



}